package com.lrz.eshop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * 梦开始的地方
 * @author 天天
 * @create 2023/1/19 17:22
 * @description
 */
@SpringBootApplication
@ServletComponentScan
// @ComponentScan(basePackages = {"com.lrz.eshop"})
// @MapperScan("com.lrz.eshop.mapper")
public class EshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(EshopApplication.class, args);
    }

}
