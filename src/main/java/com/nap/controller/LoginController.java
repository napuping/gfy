
package com.nap.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nap.entity.po.GdUser;
import com.nap.entity.result.ResultData;
import com.nap.entity.vo.GdUserQueryVo;
import com.nap.service.IUserService;
import com.nap.util.SessionUtil;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Resource
    private IUserService userService;

    // 注销
    @RequestMapping("/logout")
    public String logout(String url, HttpServletRequest request, HttpServletResponse response) {
        SessionUtil.clearParam("user", request);
        // 向浏览器写入一个退出标志，不让拦截器再进行本次拦截
        writeLogoutCookie(response, request.getContextPath());
        return "redirect:" + url;
    }

    private void writeLogoutCookie(HttpServletResponse response, String path) {
        Cookie cookie = new Cookie("logout", "1");
        cookie.setPath(path + "/");
        response.addCookie(cookie);
    }

    // 注册跳转
    /**
     * 
     * <br>
     * @param model
     * @param jumpurl 注册成功后要跳转的地址
     * @return
     * @since  SDNO 0.5
     */
    @RequestMapping("/register")
    public String goSgister(Model model,String jumpurl) {
        Integer nums = userService.queryTotalNum();
        model.addAttribute("nums", nums);
        if(!StringUtils.isEmpty(jumpurl))
            model.addAttribute("jumpurl", jumpurl);
        return "public/register";
    }

    @ResponseBody
    @RequestMapping(value = "/handLogin")
    public ResultData handLogin(GdUserQueryVo vo,
            HttpServletRequest request, HttpServletResponse response) {

        ResultData data = new ResultData();

        // 验证用户名密码是否正确
        GdUser user = userService.queryByUserAndPassword(vo, true);
        
        // 正确
        if(user != null) {
            // 验证是否启用
            String sflag = user.getSflag();
            if(!sflag.equals("0")) {
                data.setCode("300");
                data.setMessage("用户已被禁用！");
            } else {
                data.setCode("200");
                // 判断 用户是否选中 自动登录 按钮 若未选中 则 清除cookie中的信息，若选中 则向cookie中写信息
                String isSave = vo.getIsSave();
                handlerCookie(isSave, request, response, vo);
                // 将用户信息 存入session
                SessionUtil.save(request, "user", user);
            }
        }
        // 错误
        else {
            data.setCode("300");
            data.setMessage("请输入正确的用户名、密码！");
        }

        return data;
    }

    private void handlerCookie(String isSave, HttpServletRequest request, HttpServletResponse response,
            GdUserQueryVo vo) {
        // 将密码加密
        String password = DigestUtils.md5DigestAsHex(vo.getPassword().getBytes());

        // 将用户名 密码 编码
        String username = "";
        try {
            username = URLEncoder.encode(vo.getUsername(), "utf-8");
            password = URLEncoder.encode(password, "utf-8");
        } catch(UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Cookie cookiename = new Cookie("username", username);
        Cookie cookiepassword = new Cookie("password", password);
        cookiename.setPath(request.getContextPath() + "/");
        cookiepassword.setPath(request.getContextPath() + "/");
        if(StringUtils.isEmpty(isSave)) {
            cookiename.setMaxAge(0);
            cookiepassword.setMaxAge(0);
        } else {
            cookiename.setMaxAge(60 * 60 * 24 * 7);
            cookiepassword.setMaxAge(60 * 60 * 24 * 7);
        }
        response.addCookie(cookiename);
        response.addCookie(cookiepassword);
    }

}
