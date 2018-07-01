
package com.nap.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.nap.entity.po.GdAdvice;
import com.nap.entity.po.GdNotify;
import com.nap.entity.po.GdProject;
import com.nap.entity.po.GdUser;
import com.nap.entity.result.Page;
import com.nap.entity.result.ResultData;
import com.nap.entity.vo.GdProgressExtend;
import com.nap.entity.vo.GdProjectExtend;
import com.nap.entity.vo.GdProjectQueryVo;
import com.nap.entity.vo.GdTypeExtend;
import com.nap.service.IGdAdviceService;
import com.nap.service.IGdNotifyService;
import com.nap.service.IGdProgressService;
import com.nap.service.IGdProjectService;
import com.nap.service.IGdTypeService;
import com.nap.service.IUserService;
import com.nap.util.FileUtil;
import com.nap.util.MessageUtil;
import com.nap.util.RegexUtil;
import com.nap.util.SessionUtil;
import com.nap.util.StringUtil;

@Controller
@RequestMapping("/user")
public class GdUserController {

    @Resource
    private IUserService userService;

    @Resource
    private IGdProjectService projectService;

    @Resource
    private IGdTypeService gdTypeService;

    @Resource
    private IGdNotifyService gdNotifyService;

    @Resource
    private IGdProgressService gdProgressService;
    
    @Resource
    private IGdAdviceService gdAdviceService;
    // 发送信息所需参数
    @Value("${url}")
    private String url;

    @Value("${appKey}")
    private String appKey;

    @Value("${appScrect}")
    private String appScrect;

    @Value("${templateid}")
    private String templateid;

    @Value("${codeLen}")
    private String codeLen;

    // 拼接参数用到的url
    @Value("${mine_project_url}")
    private String preUrl;

    // 跳转到说明 部分
    @RequestMapping("/mine/explain")
    public String goSelf(Model model, @RequestHeader(name = "X-PJAX", required = false) String pjax) {

        // 准备公告数据
        GdNotify notify = gdNotifyService.findLastNotify();
        if(notify != null)
            model.addAttribute("notify", notify);

        // 使用pjax需要判断是pjax请求还是普通的http请求，返回不同的数据
        if(StringUtils.isEmpty(pjax))
            return "self/mine_explain";

        return "self/explainData";
    }

    // 跳转到 个人信息部分
    @RequestMapping("/mine/info")
    public String goInfo(Model model, HttpServletRequest request,
            @RequestHeader(name = "X-PJAX", required = false) String pjax) {

        if(StringUtils.isEmpty(pjax))
            return "self/mine_info";

        return "self/infoData";

    }

    // 更新个人信息
    @ResponseBody
    @RequestMapping("/mine/updateSelf")
    public ResultData update(GdUser user, HttpServletRequest request) {
        GdUser tmp = SessionUtil.getObject(request, "user", GdUser.class);
        BeanUtils.copyProperties(user, tmp, "username", "password", "sflag", "hpath", "registertime", "phone");
        user = userService.update(tmp);
        SessionUtil.save(request, "user", user);
        return ResultData.build("200", "更新成功！");
    }

    // 修改个人头像
    @ResponseBody
    @RequestMapping("/mine/changeHeader")
    public ResultData changeHeader(MultipartFile header, Integer userId, HttpServletRequest request) {
        if(StringUtils.isEmpty(userId))
            return ResultData.build("300", "用户id为空");
        if(header.getSize() > 0) {
            String rootDir = request.getSession().getServletContext().getRealPath("/");
            String filepath = String.format("static%simages%suser_header_images%s" + userId + "%s", File.separator,
                    File.separator, File.separator, File.separator);
            String filename = StringUtil.createUniqueNumber() + header.getOriginalFilename();
            String path = "";
            try {
                path = FileUtil.upload(rootDir, filepath, filename, header.getInputStream());
                // 根据id更新用户头像路径
                userService.updateHeader(userId, path);
                // 更新成功 将session中的数据更新 将原图片删除
                GdUser user = SessionUtil.getObject(request, "user", GdUser.class);
                // 删除原图片
                if(!StringUtils.isEmpty(user.getHpath()))
                    FileUtil.deleteFile(rootDir + user.getHpath());
                // 更新新路径
                user.setHpath(path);

                return ResultData.build("200", "更新成功！", path);
            } catch(RuntimeException exe) {
                exe.printStackTrace();
                return ResultData.build("300", exe.getMessage());
            } catch(Exception e) {
                e.printStackTrace();
                // 删除已经存在硬盘上的图片
                FileUtil.deleteFile(rootDir + path);
                return ResultData.build("300", "头像上传出错！");
            }
        }
        return ResultData.build("300", "无图片！");
    }

    // 跳转项目列表页面
    @RequestMapping("/mine/project")
    public String goProject(Model model, @RequestParam(defaultValue = "1", required = false) Integer curPage,
            @RequestParam(defaultValue = "10", required = false) Integer pageSize, HttpServletRequest request,
            @RequestHeader(name = "X-PJAX", required = false) String pjax, GdProjectQueryVo gdProjectQueryVo) {
        // 准备个人数据
        // 获取当前用户 id 从session
        GdUser user = SessionUtil.getObject(request, "user", GdUser.class);
        if(user != null)
            gdProjectQueryVo.setUserId(user.getUserId());
        // 取数据
        Page<GdProjectExtend> page = projectService.queryByPage(curPage, pageSize, gdProjectQueryVo);
        // 放入域中
        model.addAttribute("page", page);

        // 处理不同类型的按钮，便于传参、过滤数据
        // 类型数据
        List<GdTypeExtend> types = gdTypeService.getTypeList();
        handleUrl(types, "typecode", gdProjectQueryVo);
        model.addAttribute("types", types);
        // 语言数据
        List<GdTypeExtend> lans = gdTypeService.getLanList();
        handleUrl(lans, "lancode", gdProjectQueryVo);
        model.addAttribute("lans", lans);
        // 其他分类

        // 处理分页按钮url连接参数 （累加过滤参数和排序参数）
        String filter = handlerFilterParam(gdProjectQueryVo);
        String phref = createPageBtnHref(filter, "");
        // 传入链接 生成按钮 放入model
        String btns = page.generateButton(phref);
        model.addAttribute("btns", btns);

        // 处理全部按钮链接
        // 全部类型 按钮链接
        String alltypeurl = writeUrl("typecode", gdProjectQueryVo);
        alltypeurl = alltypeurl.equals("") ? preUrl : preUrl + "?" + alltypeurl;
        model.addAttribute("alltypeurl", alltypeurl);
        // 全部语言按钮 链接
        String alllanurl = writeUrl("lancode", gdProjectQueryVo);
        alllanurl = alllanurl.equals("") ? preUrl : preUrl + "?" + alllanurl;
        model.addAttribute("alllanurl", alllanurl);

        // 记录当前参数值 便于前台区别展示
        // 记录当前typecode值
        String typecode = gdProjectQueryVo.getTypecode();
        typecode = StringUtils.isEmpty(typecode) ? "" : typecode;
        model.addAttribute("activetype", typecode);
        // 记录当前lancode值
        String lancode = gdProjectQueryVo.getLancode();
        lancode = StringUtils.isEmpty(lancode) ? "" : lancode;
        model.addAttribute("activelan", lancode);

        // pjax请求判断
        if(StringUtils.isEmpty(pjax))
            return "self/mine_project";

        return "self/projectData";
    }

    // 综合过滤参数和排序参数 用于分页按钮链接
    public String createPageBtnHref(String filter, String orderby) {
        String phref = "";
        if(StringUtils.isEmpty(filter) && !StringUtils.isEmpty(orderby))
            phref = preUrl + "?" + orderby;
        else if(!StringUtils.isEmpty(filter) && StringUtils.isEmpty(orderby))
            phref = preUrl + "?" + filter;
        else if(StringUtils.isEmpty(filter) && StringUtils.isEmpty(orderby))
            phref = preUrl;
        else
            phref = preUrl + "?" + filter + "&" + orderby;
        if(phref.indexOf("?") != -1)
            phref += "&curPage=";
        else
            phref += "?curPage=";
        return phref;
    }

    // 拼接不为空的过滤参数
    public String handlerFilterParam(GdProjectQueryVo gdProjectQueryVo) {
        String param = "";
        String typecode = gdProjectQueryVo.getTypecode();
        if(!StringUtils.isEmpty(typecode)) {
            param += "typecode=" + typecode + "&";
        }
        String lancode = gdProjectQueryVo.getLancode();
        if(!StringUtils.isEmpty(lancode)) {
            param += "lancode=" + lancode + "&";
        }
        return param.equals("") ? param : param.substring(0, param.length() - 1);
    }

    // 参数拼接原则：同一类型，不论有无值都不进行拼接，不同类型，有值进行拼接，无不拼接
    // 遍历GdTypeExtend，将不同类型的有值的参数进行与自己拼接
    public void handleUrl(List<GdTypeExtend> datas, String type, GdProjectQueryVo vo) {
        String param = writeUrl(type, vo);
        for(GdTypeExtend gdTypeExtend : datas) {
            String url = preUrl + "?" + type + "=" + gdTypeExtend.getTcode() + (param.equals("") ? param : "&" + param);
            gdTypeExtend.setUrl(url);
        }
    }

    // 不是自己类型的且有值的就拼接
    public String writeUrl(String type, GdProjectQueryVo vo) {
        String param = "";
        if(!type.equals("typecode") && !StringUtils.isEmpty(vo.getTypecode())) {
            String typecode = vo.getTypecode();
            param += "typecode=" + typecode + "&";
        }
        if(!type.equals("lancode") && !StringUtils.isEmpty(vo.getLancode())) {
            String lancode = vo.getLancode();
            param += "lancode=" + lancode + "&";
        }
        // 若有其他类型，依次添加
        return param.equals("") ? param : param.substring(0, param.length() - 1);
    }

    // 跳转项目申请页面
    @RequestMapping("/mine/project/apply")
    public String goApply(Model model, @RequestHeader(name = "X-PJAX", required = false) String pjax) {
        // 准备数据
        List<GdTypeExtend> types = gdTypeService.getTypeList();
        List<GdTypeExtend> lans = gdTypeService.getLanList();
        model.addAttribute("types", types);
        model.addAttribute("lans", lans);

        if(StringUtils.isEmpty(pjax))
            return "self/mine_apply";

        return "self/applyData";
    }

    // 跳转匿名申请页面
    @RequestMapping("/anonymous/apply")
    public String goAnonymousApply(Model model) {
        // 准备数据
        List<GdTypeExtend> types = gdTypeService.getTypeList();
        List<GdTypeExtend> lans = gdTypeService.getLanList();
        model.addAttribute("types", types);
        model.addAttribute("lans", lans);
        return "public/anonyApply";
    }

    // 跳转项目更新页面
    @RequestMapping("/mine/update/{projectId}")
    public String goUpdateProject(@PathVariable Integer projectId,
            @RequestHeader(name = "X-PJAX", required = false) String pjax, Model model) {

        // 准备数据
        List<GdTypeExtend> types = gdTypeService.getTypeList();
        List<GdTypeExtend> lans = gdTypeService.getLanList();
        model.addAttribute("types", types);
        model.addAttribute("lans", lans);

        GdProject project = projectService.findById(projectId);
        model.addAttribute("project", project);

        if(StringUtils.isEmpty(pjax))
            return "self/mine_update";

        return "self/updateData";
    }

    // 跳转进度页面
    @RequestMapping("/mine/progress/{projectId}")
    public String goProgress(@PathVariable Integer projectId, HttpServletRequest request,
            @RequestHeader(name = "X-PJAX", required = false) String pjax, Model model) throws NoHandlerFoundException {

        // 根据id取项目信息
        GdProjectExtend project = projectService.findByIdUseExtend(projectId);
        if(project == null)
            throw new NoHandlerFoundException(request.getMethod(), request.getRequestURI(), null);
        model.addAttribute("project", project);

        // 取项目进度信息
        List<GdProgressExtend> progresss = gdProgressService.queryByProjectId(projectId);
        model.addAttribute("progresss", progresss);

        if(StringUtils.isEmpty(pjax))
            return "self/mine_progress";

        return "self/progressData";
    }

    // 查看文档
    @RequestMapping(value = "/mine/checkFile")
    @ResponseBody
    public ResultData checkFile(String filepath, HttpServletRequest request) {
        String rootDir = request.getSession().getServletContext().getRealPath("/");
        File file = new File(rootDir + filepath);
        BufferedReader reader = null;
        StringBuffer sb = new StringBuffer();
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String content = reader.readLine();
            while(content != null) {
                sb.append(content + "\n");
                content = reader.readLine();
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(reader != null)
                    reader.close();
            } catch(Exception e2) {
            }
        }
        return ResultData.build(sb.toString());
    }

    // 下载文档
    @RequestMapping("/mine/download/{id}")
    public void download(@PathVariable Integer id, HttpServletRequest request, HttpServletResponse response) {
        GdProject project = projectService.findById(id);
        if(project == null || StringUtils.isEmpty(project.getFilepath()))
            return;
        String filepath = project.getFilepath();
        FileUtil.download(request.getSession().getServletContext().getRealPath("/") + filepath, project.getFilename(),
                response);
    }

    // 更新项目
    @ResponseBody
    @RequestMapping("/mine/update")
    public ResultData updateProject(GdProject project, MultipartFile file, String changeFlag,
            HttpServletRequest request) {
        // 如果 file 不为空 肯定选择了文件，如果原来存在文件 就删除，重新生成新的
        // 如果file 为空 ，分两种情况，1、没点击更新文件按钮、此时还是旧文档 2、点击了更新按钮，最后又选择了格式不对的文件，此时会清空原来选择的文档
        String path = null;
        if(file != null && file.getSize() > 0) {
            if(!StringUtils.isEmpty(project.getFilepath()))
                FileUtil.deleteFile(request.getSession().getServletContext().getRealPath("/") + project.getFilepath());
            try {
                path = getUploadPath(request, StringUtil.createUniqueNumber() + "" + file.getOriginalFilename(),
                        file.getInputStream());
            } catch(IOException e) {
                path = null;
                e.printStackTrace();
            }
        } else if(file == null || file.getSize() == 0) {
            if(StringUtils.isEmpty(changeFlag)) {
                // 为空 说明还是旧文件 不用做操作
                path = project.getFilepath();
            } else {
                // 不为空说明 改变了 最终又置为空 如果原来存在则删除置为空
                if(!StringUtils.isEmpty(project.getFilepath()))
                    FileUtil.deleteFile(
                            request.getSession().getServletContext().getRealPath("/") + project.getFilepath());
                path = null;
            }
        }
        project.setFilepath(path);
        try {
            projectService.update(project);
            return ResultData.build("200", "更新成功！");
        } catch(Exception e) {
            e.printStackTrace();
            return ResultData.build("300", e.getMessage());
        }
    }

    // 得到上传文件路径
    private String getUploadPath(HttpServletRequest request, String filename, InputStream inputStream) {
        String rootDir = request.getSession().getServletContext().getRealPath("/");
        GdUser user = SessionUtil.getObject(request, "user", GdUser.class);
        String filepath = null;
        if(user != null)
            filepath = String.format("static%supload%s" + user.getUserId() + "%s", File.separator, File.separator,
                    File.separator);
        else
            filepath = String.format("static%supload%sanonymous%s", File.separator, File.separator, File.separator);
        return FileUtil.upload(rootDir, filepath, filename, inputStream);
    }

    // 重新申请
    @ResponseBody
    @RequestMapping("/mine/reapply/{projectId}")
    public ResultData reapply(@PathVariable Integer projectId) {
        GdProject project = new GdProject();
        project.setProjectId(projectId);
        project.setStatus("0");
        try {
            projectService.updateForStatus(project);
            return ResultData.build("200", "重新申请成功！");
        } catch(Exception e) {
            e.printStackTrace();
            return ResultData.build("300", "重新申请失败！请稍后重试！");
        }
    }

    // 查看详细信息
    @ResponseBody
    @RequestMapping("mine/lookDetail/{projectId}")
    public ResultData lookDetail(@PathVariable Integer projectId) {
        GdProjectExtend project = projectService.findByIdUseExtend(projectId);
        return ResultData.build(project);
    }

    // 删除项目信息
    @ResponseBody
    @RequestMapping("mine/delete/{id}")
    public ResultData delete(@PathVariable Integer id, HttpServletRequest request) {
        try {
            projectService.deleteById(request, id);
            return ResultData.build("200", "删除成功！");
        } catch(Exception e) {
            e.printStackTrace();
            return ResultData.build("300", e.getMessage());
        }
    }

    // 检测账号是否存在
    @ResponseBody
    @RequestMapping("/register/checkUsername")
    public ResultData checkUsername(String username) {
        GdUser user = userService.isExistByUsername(username);
        if(user != null) {
            return ResultData.build("300", "账号已存在！");
        }
        return ResultData.build("200", "用户名可用！");
    }

    // 发送验证码
    @ResponseBody
    @RequestMapping("/register/sendCode")
    public ResultData sendCode(String mobile, HttpServletRequest request) {

        ResultData data = new ResultData();

        if(StringUtils.isEmpty(mobile) || !RegexUtil.checkPhone(mobile)) {
            return ResultData.build("300", "手机号格式不正确");
        }
        // 发送验证码之前 验证是否是重复点击
        Integer num = SessionUtil.getObject(request, mobile, Integer.class);
        if(num != null)
            return ResultData.build("300", "操作频繁！");

        // 判断是否是已注册用户
        GdUser user = userService.queryUserByPhone(mobile);
        if(user != null)
            return ResultData.build("300", "你已注册了，请登录！");

        data = MessageUtil.sendMessage(url, mobile, appKey, appScrect, templateid, codeLen);
        if(data.getCode().equals("200")) {
            // 验证码成功 存入session
            SessionUtil.save(request, "checkcode", data.getData());
            // 将成功的手机号放入session 避免用户重复点击 验证码
            SessionUtil.save(request, mobile, 1);
        }
        return data;
    }

    // 注册
    @ResponseBody
    @RequestMapping(value = "/register/register", method = RequestMethod.POST)
    public ResultData register(GdUser user, String checkcode, HttpServletRequest request) {
        // 验证 验证码是否正确 注销便于测试
        String codeexist = SessionUtil.getObject(request, "checkcode", String.class);
        if(StringUtils.isEmpty(checkcode) || StringUtils.isEmpty(codeexist) || !checkcode.trim().equals(codeexist))
            return ResultData.build("300", "验证码不正确!");
        try {
            userService.save(user);
            // 注册成功 移除校验码 自动登录
            SessionUtil.clearParam("checkcode", request);
            SessionUtil.save(request, "user", user);

            return ResultData.build("200", "注册成功!");
        } catch(Exception e) {
            e.printStackTrace();
            return ResultData.build("300", e.getMessage());

        }
    }

    // 跳转意见
    @RequestMapping("/mine/advice")
    public String advice(@RequestHeader(name = "X-PJAX", required = false) String pjax) {
        
        if(StringUtils.isEmpty(pjax))
            return "self/mine_advice";

        return "self/adviceData";
    }
    
    //提交意见
    @ResponseBody
    @RequestMapping("/mine/commitAdvice")
    public ResultData commitAdvice(HttpServletRequest request,GdAdvice advice){
        GdUser user = SessionUtil.getObject(request, "user", GdUser.class);
        advice.setUserId(user.getUserId());
        gdAdviceService.insert(advice);
        return ResultData.build("200", "提交成功！");
    }

}
