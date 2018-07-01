
package com.nap.websocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.nap.websocket.handler.WebsocketHandler;
import com.nap.websocket.interceptor.WebsocketHandsharkInterceptor;

@Configuration
@EnableWebSocket
public class WebsocketConfig implements WebSocketConfigurer{

   // private WebsocketHandler websocketHandler = new WebsocketHandler();
    
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        //websocket地址
        String surl = "/websocket/socketServer";
        registry.addHandler(textWebSocketHandler(), surl)
        .addInterceptors(new WebsocketHandsharkInterceptor());
      //  .setAllowedOrigins("http://localhost:80");
        
        //sockjs地址
        surl = "/sockjs/socketServer";
        registry.addHandler(textWebSocketHandler(), surl)
        .addInterceptors(new WebsocketHandsharkInterceptor())
       // .setAllowedOrigins("http://localhost:80")
        .withSockJS();
        
        System.out.println("配置成功");
    }
    
    //@Bean方法上的注解，用于将方法产生的bean放入容器
    @Bean
    public TextWebSocketHandler textWebSocketHandler(){
        return new WebsocketHandler();
    }

}
