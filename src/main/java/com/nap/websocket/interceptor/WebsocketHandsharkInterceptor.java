
package com.nap.websocket.interceptor;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

public class WebsocketHandsharkInterceptor implements HandshakeInterceptor{

    private Logger logger = LoggerFactory.getLogger(WebsocketHandsharkInterceptor.class);
    @Override
    public void afterHandshake(ServerHttpRequest serverHttpRequest,
            ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception exception) {
        System.out.println("建立连接");
    }

    @Override
    public boolean beforeHandshake(ServerHttpRequest serverHttpRequest, 
                ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler,
            Map<String, Object> attri) throws Exception {
        //处理websocket标识
        ServletServerHttpRequest request = null;
        if(serverHttpRequest instanceof ServletServerHttpRequest)
            request = (ServletServerHttpRequest)serverHttpRequest;
        System.out.println(request == null);
        HttpSession session = request.getServletRequest().getSession(false);
        System.out.println(session==null);
        if(session != null) {
           Object obj = session.getAttribute("user");
           if(obj != null){
             /*  User user = (User)obj;
               attri.put("user", user);*/
           }
        }
        return true;
    }

}
