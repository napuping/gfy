
package com.nap.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.nap.entity.po.GdLook;
import com.nap.entity.po.GdProject;
import com.nap.entity.po.GdUser;
import com.nap.entity.result.Page;
import com.nap.entity.result.ResultData;
import com.nap.entity.vo.GdCommentExtend;
import com.nap.entity.vo.GdCommentQueryVo;
import com.nap.entity.vo.GdProjectExtend;
import com.nap.service.IGdCommentService;
import com.nap.service.IGdLookService;
import com.nap.service.IGdProjectService;
import com.nap.util.FileUtil;
import com.nap.util.SessionUtil;
import com.nap.util.StringUtil;

@Controller
@RequestMapping("/project")
public class GdProjectController {
    
    @Resource
    private IGdProjectService projectService;
    
    @Resource
    private IGdLookService gdLookService;
    
    @Resource
    private IGdCommentService gdCommentService;
    
    @RequestMapping("/{id}")
    public String lookDeatail(@PathVariable Integer id,Model model,
                HttpServletRequest request,GdCommentQueryVo vo, 
                    @RequestParam(defaultValue="1") int curPage,@RequestParam(defaultValue="5") int pageSize) throws NoHandlerFoundException{
        //记录用户信息 插入gd_look表
        if(StringUtils.isEmpty(request.getParameter("curPage"))){
            try {
                record(request, id);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        //根据id取项目信息
        GdProjectExtend project = projectService.findByIdUseExtend(id);
        if(project == null)
            throw new NoHandlerFoundException(request.getMethod(), request.getRequestURI(),null);
        model.addAttribute("project", project);
        
        //准备评论数据
        vo.setProjectId(id);
        //获取全部评论数
        long count = gdCommentService.countComments(id);
        model.addAttribute("count", count);
        
        Page<GdCommentExtend> page = gdCommentService.getParentComment(vo, curPage, pageSize);
        //生成分页按钮
        String href = "project/" + id + ".html?curPage=";
        model.addAttribute("btns", page.generateButton(href));
        model.addAttribute("page", page);
        
        return "public/detail";
    }
    //子评论 分页 利用ajax来加载
    @RequestMapping("/subPage")
    public String subPage(Model model,@RequestParam(defaultValue="1")
        int curPage,@RequestParam(defaultValue="5") int pageSize,Integer parentId){
        
        Page<GdCommentExtend> subPage = 
                gdCommentService.getSubComment(curPage, pageSize, parentId);
        model.addAttribute("parentId", parentId);
        model.addAttribute("subPage", subPage);
        
       return "public/subPageData";
    }
    
    //记录浏览信息
    private void record(HttpServletRequest request,Integer id){
        GdLook look = new GdLook();
        String lookerip = request.getRemoteAddr();
        String looker = null;
        GdUser user = SessionUtil.getObject(request, "user", GdUser.class);
        if(user != null)
            looker = user.getUsername();
        else
            looker = "游客";
        Integer projectId = id;
        look.setLookip(lookerip);
        look.setLooker(looker);
        look.setProjectId(projectId);
        gdLookService.insert(look);
    }
    
    //项目申请
    @ResponseBody
    @RequestMapping("/apply")
    public ResultData apply(HttpServletRequest request, GdProject project,MultipartFile file){
       
        if(StringUtils.isEmpty(project.getIsanonymous())){//若匿名字段为空 说明是从个人中心申请 此时已登录 也有session失效的情况
            GdUser user = SessionUtil.getObject(request, "user", GdUser.class);
            if(user == null)
                throw new RuntimeException("会话过期，请重新登录！");
            else
                project.setUserId(user.getUserId());
        }
        //获取上传路径 文件上传异常 不影响后续 流程
        String filepath = null;
        if(file.getSize() == 0)
            project.setFilepath(null);
        else
            try {
                //随机生成数字 加在文件名前 防止重复
               filepath = getUploadPath(request,
                         StringUtil.createUniqueNumber()
                              + "" + file.getOriginalFilename(), file.getInputStream());
            } catch(IOException e1) {
                filepath = null;
                e1.printStackTrace();
            }
        project.setFilepath(filepath);
        try {
            projectService.insert(project);
            return ResultData.build("200", "项目申请成功！");
        } catch(Exception e) {
            e.printStackTrace();
            return ResultData.build("300", e.getMessage());
        }
    }
    
    //得到上传文件路径
    private String getUploadPath(HttpServletRequest
                request,String filename,InputStream inputStream){
        String rootDir = request.getSession().getServletContext().getRealPath("/");
        GdUser user = SessionUtil.getObject(request, "user", GdUser.class);
        String filepath = null;
        if(user != null)
            filepath = String.format("static%supload%s" + user.getUserId() + "%s", File.separator,File.separator,File.separator);
        else
            filepath = String.format("static%supload%sanonymous%s", File.separator,File.separator,File.separator);
        return FileUtil.upload(rootDir, filepath, filename, inputStream);
    }
    
    
    
}
