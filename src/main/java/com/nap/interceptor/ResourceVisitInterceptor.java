
package com.nap.interceptor;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.nap.entity.po.GdUser;
import com.nap.util.SessionUtil;

public class ResourceVisitInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
       //session中取user
        GdUser user = SessionUtil.getObject(request, "user", GdUser.class);
        //System.out.println(user == null);
        if(user == null){
            //未登录访问的时候 可能是直接通过刷新页面  可能通过ajax 也可能通过pjax
            //如果是ajax请求  直接抛出异常 并 设置异常信息为 会话已过期，请重新登录！
            int i = judgeRequestType(request);
            if(i == 1)
                throw new RuntimeException("会话已过期，请重新登录！");
            //如果是pjax 也是一种ajax请求，只不过返回的是页面 则单独创建一个提示页面，跳转到此页面
            else if(i == 2){
             // request.getRequestDispatcher("/error/goPjaxError").forward(request, response);
                response.setCharacterEncoding("UTF-8");
                response.getWriter().
                    write("<label style='margin-top:10px;'><font color='red'>会话已过期，请重新登录！</font></label>");
            }
            //如果是一般请求 则直接重定向到首页
            else{
                response.sendRedirect(request.getContextPath() + "/");
            }
            return false;
        }else{
            return true;
        }
    }
    //如果返回1 则说明是ajax 返回2 说明是pjax 如果为0 说明一般请求
    private int judgeRequestType(HttpServletRequest request){
        Enumeration names = request.getHeaderNames();
        int  i = 0;
        while(names.hasMoreElements()){
            String nametmp = (String)names.nextElement();
            if("X-Requested-With".equalsIgnoreCase(nametmp))
                i++;
            else if("X-PJAX".equalsIgnoreCase(nametmp))
                i++;
        }
        return i;
    }
  /*  //判断headers中是否存在某个参数   --当为pjax请求时 即有x-pjax 也有x-requested-with 
    private boolean isExistParameter(HttpServletRequest request, String name){
       @SuppressWarnings("rawtypes")
    Enumeration names = request.getHeaderNames();
       while(names.hasMoreElements()){
           String nametmp = (String)names.nextElement();
           System.out.println(nametmp  + "_");
           if(name.equalsIgnoreCase(nametmp))
               return true;
       }
       return false;
    }*/

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        
    }
    
    
    
}
