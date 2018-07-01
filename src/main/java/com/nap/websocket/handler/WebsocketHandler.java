
package com.nap.websocket.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class WebsocketHandler extends TextWebSocketHandler {
       
    private final static List<WebSocketSession> sessions = new ArrayList<WebSocketSession>();

    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session);
        System.out.println("关闭连接：" + sessions.size());
    }

    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
        System.out.println("建立连接:" + sessions.size());
    }

    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println(session.getId());
        System.out.println(session.getAttributes());
        System.out.println(message.getPayload());
    }

    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        if(session.isOpen())
            session.close();
        sessions.remove(session);
    }
    
    public void sendAll(String message) throws IOException{
        for(WebSocketSession session : sessions){
            WebSocketMessage<String> sm = new TextMessage(message);
            session.sendMessage(sm);
        }
    }

}
