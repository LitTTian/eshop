package com.lrz.eshop.config;

import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

/**
 * 获取HttpSession对象
 * @author 天天
 * @create 2023/3/9 14:50
 * @description
 */
public class GetHttpSessionConfigurator extends ServerEndpointConfig.Configurator {
    @Override
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
        // HandshakeRequest封装了request对象，可以获取request对象中的信息
        HttpSession httpSession = (HttpSession) request.getHttpSession();
        // httpSession对象存储到配置对象
        sec.getUserProperties().put(HttpSession.class.getName(), httpSession);
    }
}