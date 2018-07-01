
package com.nap.interceptor;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.Resource;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

public class TimeCountInteceptor implements HandlerInterceptor {

    AtomicLong start = new AtomicLong();

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object method, Exception arg3)
            throws Exception {
        long ex = (System.currentTimeMillis() - start.get());
        if(method instanceof HandlerMethod) {
            HandlerMethod hm = (HandlerMethod)method;
            String name = hm.getMethod().getName();
            System.out.println("方法[" + name + "]执行结束");
        }else{
            System.out.println("静态资源请求结束");
        }
        System.out.println("共耗时：" + ex  + "ms");
        System.out.println("----------------------------------------");

    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {
        System.out.println("方法执行中。。。");

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object method) throws Exception {
        start.set(System.currentTimeMillis());
        if(method instanceof HandlerMethod) {
            HandlerMethod hm = (HandlerMethod)method;
            System.out.println(hm.getBean().getClass().getName());
            String name = hm.getMethod().getName();
            System.out.println("方法[" + name + "]开始执行");
        }else{
            ResourceHttpRequestHandler rhr = (ResourceHttpRequestHandler)method;
            List<Resource> locations = rhr.getLocations();
            System.out.println("开始请求静态资源:[" );
            for(Resource resource : locations){
                System.out.println(resource.getURL() + "_" +  resource.getURI() + "_" + resource.getFilename());
            }
            System.out.println("]");
        }

        return true;
    }

}
