package com.lrz.eshop.config;

import com.lrz.eshop.component.ChatEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * WebSocket配置类
 * @author 天天
 * @create 2023/3/10 17:43
 * @description
 */

@Configuration
public class WebSocketConfig {

    @Bean // 注入ServerEndpointExporter，这个bean会自动注册使用了@ServerEndpoint注解声明的Websocket endpoint
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
