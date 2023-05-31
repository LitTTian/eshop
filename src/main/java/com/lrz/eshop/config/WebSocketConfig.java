package com.lrz.eshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

/**
 * WebSocket配置类
 * @author 天天
 * @create 2023/3/10 17:43
 * @description
 */

@Configuration
public class WebSocketConfig extends  ServerEndpointConfig.Configurator {


    @Override
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
        // HandshakeRequest封装了request对象，可以获取request对象中的信息
        HttpSession httpSession = (HttpSession)request.getHttpSession();
        // System.out.println("modifyHandshake");
        // System.out.println(request.getHeaders());
        if (httpSession != null) { // 读取session域中存储的数据
            // sec.getUserProperties().put("token", request.getHeaders().get("token"));
            sec.getUserProperties().put(HttpSession.class.getName(),httpSession);
        }
        super.modifyHandshake(sec, request, response);
    }

    @Bean // 注入ServerEndpointExporter，这个bean会自动注册使用了@ServerEndpoint注解声明的Websocket endpoint
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

}
