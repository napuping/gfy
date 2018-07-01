
package com.nap.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtil {
    
    public static void save(HttpServletRequest request,String name,Object obj){
        HttpSession session = request.getSession();
        session.setAttribute(name, obj);
    }
    
    @SuppressWarnings("unchecked")
    public static <T> T getObject(HttpServletRequest request,String name,Class<T> clazz){
        HttpSession session = request.getSession();
        return (T)session.getAttribute(name);
    }
    
    //清除session属性
    public static void clearParam(String name,HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute(name);
    }

    //得到根路径
    public static  String getRootDir(HttpServletRequest request){
        String rootDir = request.getSession().getServletContext().getRealPath("/");
        return rootDir;
    }
}
