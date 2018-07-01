
package com.nap.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.nap.entity.result.ResultData;
import com.nap.util.JsonUtil;

@ControllerAdvice
public class GlobalExeptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ModelAndView handlerExceptionMethod(
            HttpServletRequest request, HttpServletResponse response,Exception e)
            throws IOException {
        if(e instanceof NoHandlerFoundException) {
            return exceptionProcess(request, response, ResultData.build("404", "资源找不到！"), "error/404");
        } else {
            return exceptionProcess(request, response, ResultData.build("300", e.getMessage()), "error/error");
        }
    }

    private ModelAndView exceptionProcess(HttpServletRequest request, HttpServletResponse response, ResultData data,
            String viewname) throws IOException {
       
        if("XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"))) {//ajax请求时
            // 设置response返回编码 及 格式
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=utf-8");
            String json = JsonUtil.bean2Json(data);
            response.getWriter().write(json);
            return null;
        } else {//一般请求时
            ModelAndView mav = new ModelAndView();
            mav.addObject("error", data.getMessage());
            mav.setViewName(viewname);
            return mav;
        }
    }

}
