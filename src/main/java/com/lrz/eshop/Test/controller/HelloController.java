package com.lrz.eshop.Test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * hello Controller
 * @author 天天
 * @create 2023/1/19 2:05
 * @description
 */
@RestController
public class HelloController {

    //  http://localhost:8080/hello
    //  http://localhost:8080/hello?nickname=zhangsan&phone=123
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(String nickname,String phone){
        System.out.println(phone);
        return "你好" + nickname;
    }
}

