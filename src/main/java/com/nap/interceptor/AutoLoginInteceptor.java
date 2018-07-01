
package com.nap.interceptor;

import java.net.URLDecoder;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.nap.entity.po.GdUser;
import com.nap.entity.vo.GdUserQueryVo;
import com.nap.service.IUserService;
import com.nap.util.SessionUtil;

public class AutoLoginInteceptor implements HandlerInterceptor{

    @Resource
    private IUserService userService; 
    
    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        
    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {
        
    }
    
    private String getValueFromCookie(HttpServletRequest request, String name){
        String result = "";
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length > 0){
            for(Cookie cookie : cookies){
                String nametmp = cookie.getName();
               if(name.equals(nametmp)){
                   result = cookie.getValue();
                  break;
               }
            }
        }
        return result;
    }
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
        
        
        //先判断是否有退出标志，若有则直接放行
        String logoutflag = getValueFromCookie(request, "logout");
        if(!StringUtils.isEmpty(logoutflag))
            return true;
        
        //先判断用户是否登录，若已登录则 直接放行
        GdUser user = SessionUtil.getObject(request, "user",GdUser.class);
        if(user != null)
            return true;
        else{
            //获取用户cookies，得到用户名密码
            Cookie[] cookies = request.getCookies();
            String username = "";
            String password = "";
            if(cookies != null && cookies.length > 0){
                for(Cookie cookie : cookies){
                    String name = cookie.getName();
                    if("username".equals(name))
                        username = cookie.getValue();
                    else if("password".equals(name))
                        password = cookie.getValue();
                }
            }
            if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password))
                return true;
            else{
                //从cookie获取的用户名 密码 解码
                username = URLDecoder.decode(username, "utf-8");
                password = URLDecoder.decode(password, "utf-8");
                //从数据库中 比对信息 是否正确 若正确则 放入session，若不正确 则放行
                
                GdUserQueryVo vo = new GdUserQueryVo();
                vo.setUsername(username);
                vo.setPassword(password);
                //判断是否存在正确的用户名信息
                user = userService.queryByUserAndPassword(vo, false);
                if(user == null)
                    return true;
                else{
                    SessionUtil.save(request, "user", user);
                    return true;
                }
            }
        }
    }
}
