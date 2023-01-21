package com.lrz.eshop.Test.controller;

import com.lrz.eshop.common.webapi.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 天天
 * @create 2023/1/21 15:14
 * @description
 */
@RestController
@RequestMapping("/api/v1/test")
public class TestController {
    @PostMapping("/pMapping")
    public Result<?> pMapping(@RequestBody String requestBody){
        System.out.println("requestBody");
        return Result.success(requestBody);
    }
}
