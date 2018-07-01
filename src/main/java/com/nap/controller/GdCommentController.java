
package com.nap.controller;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.nap.entity.po.GdComment;
import com.nap.entity.po.GdProject;
import com.nap.entity.po.GdUser;
import com.nap.entity.result.ResultData;
import com.nap.service.IGdCommentService;
import com.nap.service.IGdProjectService;
import com.nap.util.FileUtil;
import com.nap.util.SessionUtil;
import com.nap.util.StringUtil;

@Controller
@RequestMapping("/comment")
public class GdCommentController {

    @Resource
    private IGdCommentService gdCommentService;
    
    @Resource
    private IGdProjectService gdProjectService;
    
    //评论
    @ResponseBody
    @RequestMapping("/comment")
    public ResultData comment(GdComment comment,HttpServletRequest request){
        GdUser user = SessionUtil.getObject(request, "user", GdUser.class);
        String res = "无权评论！";
        if(user == null)
            return ResultData.build("300", res);
        if(StringUtils.isEmpty(comment.getContent()))
            return ResultData.build("300", "数据非法！");
        if(StringUtils.isEmpty(comment.getProjectId()))
            return ResultData.build("300", "数据非法！");
        GdProject project = gdProjectService.findById(comment.getProjectId());
        if(StringUtils.isEmpty(project.getUserId()))
            return ResultData.build("300", res);
        if(!project.getUserId().equals(user.getUserId()))
            return ResultData.build("300", res);
        //插入评论数据
        //写入评论人
        comment.setUserId(user.getUserId());
        comment.setCommenttime(new Date());
        try {
            gdCommentService.insert(comment);
            return ResultData.build("200", "评论成功！");
        } catch(Exception e) {
            return ResultData.build("300", "插入异常！");
        }
    }
    //回复
    @ResponseBody
    @RequestMapping("/reply")
    public ResultData reply(GdComment comment,HttpServletRequest request){
        GdUser user = SessionUtil.getObject(request, "user", GdUser.class);
        if(user != null)
            comment.setUserId(user.getUserId());
        try {
            gdCommentService.reply(comment);
            return ResultData.build("200", "回复成功！");
        }catch(RuntimeException re){
            re.printStackTrace();
            return ResultData.build("300", re.getMessage());
        } catch(Exception e) {
            return ResultData.build("300", "回复失败！");
        }
    }
    //评论图片上传
    @ResponseBody
    @RequestMapping(value = "/upload")
    public Map uploadImage(MultipartFile imgFile,HttpServletRequest request){
       //得到根路径
        String rootDir = SessionUtil.getRootDir(request);
       //拼接上传文件夹的相对路径
        Calendar cal = Calendar.getInstance();
        String time = cal.get(Calendar.YEAR) + "" + 
                (cal.get(Calendar.MONTH) + 1) + "" + cal.get(Calendar.DATE);
        String uploadDir = String.format("static%simages%scomment%s" + time + "%s", 
                    File.separator,File.separator,File.separator,File.separator);
        if(imgFile.getSize() > 0){
            String filename = StringUtil.createUniqueNumber() + imgFile.getOriginalFilename();
            try {
                String path = FileUtil.upload(rootDir, uploadDir, filename, imgFile.getInputStream());
                if(!StringUtils.isEmpty(path)){
                    return getMap(0, "/" + path);
                }
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        return getMap(1, "上传异常");
    }
    @SuppressWarnings({"rawtypes", "unchecked"})
    private Map getMap(int error,String message){
        Map obj = new HashMap();
        obj.put("error", error);
        obj.put("url", message);
        return obj;
    }
}
