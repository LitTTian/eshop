package com.lrz.eshop.config;

import com.lrz.eshop.interceptor.JWTInterceptor;
import com.lrz.eshop.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebMvc配置类
 * @author 天天
 * @create 2023/1/19 6:00
 * @description
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 跨域配置
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 设置前端port
        registry.addMapping("/**") // 允许跨域访问的路径
                .allowedOrigins("http://localhost:8080") // 允许跨越访问的源
                .allowCredentials(true) // 允许跨域传输cookie
                .allowedHeaders("*") // 允许的头部
                .allowedMethods("*") // 允许的请求方法
                .maxAge(30000) // 预检间隔时间
                .allowCredentials(true); // 是否发送cookie
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // registry.addInterceptor( new LoginInterceptor()).addPathPatterns("/user/**");
        registry.addInterceptor(new JWTInterceptor())
                .addPathPatterns("/api/trade/**")
                .addPathPatterns("/api/star/**")
                .addPathPatterns("/api/do/**")
                .addPathPatterns("/api/message/**")
                .addPathPatterns("/api/location/**")
                // .addPathPatterns("/ws") // 添加拦截器后，websocket能正确拿到session
                .excludePathPatterns("/api/user/**")
                .excludePathPatterns("/api/login/**");
    }

    /**
     * 是因为swagger-ui.html 是在springfox-swagger-ui.jar里的，因为修改了路径Spring Boot不会自动把/swagger-ui.html这个路径映射到对应的目录META-INF/resources/下面。
     * 所以我们修改springboot配置类，为swagger建立新的静态文件路径映射就可以了
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/statics/**")
                .addResourceLocations("classpath:/statics/");
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}
