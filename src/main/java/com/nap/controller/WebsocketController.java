
package com.nap.controller;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nap.websocket.handler.WebsocketHandler;

@Controller
public class WebsocketController {

    @Resource
    private WebsocketHandler websocketHandler;
    
    @ResponseBody
    @RequestMapping("/send")
    public String send(){
        try {
            websocketHandler.sendAll("hello");
            //发送成功，可以将信息插入数据库
            
            return "ok";
        } catch(IOException e) {
            e.printStackTrace();
        }
        return "false";
    }
    
  /*  @ResponseBody
    @RequestMapping("/cs")
    public String createSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = new User();
        user.setId("1");
        user.setName("tom");
        session.setAttribute("user", user);
        return "ok";
    }*/
}
