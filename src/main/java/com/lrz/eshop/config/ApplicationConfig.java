package com.lrz.eshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 天天
 * @create 2023/1/21 4:09
 * @description
 */
@Configuration
public class ApplicationConfig  {

    @Bean(name = "freeMarkerConfigurer")
    public FreeMarkerConfigurer freeMarkerConfigurer() {
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        configurer.setDefaultEncoding("UTF-8");
        configurer.setTemplateLoaderPath("classpath:/ftl");
        Map<String, Object> variables = new HashMap<>(1<<1);
        variables.put("xml_escape","fmXmlEscape");
        configurer.setFreemarkerVariables(variables);
        return configurer;
    }
}
