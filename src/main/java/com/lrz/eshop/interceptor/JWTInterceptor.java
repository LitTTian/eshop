package com.lrz.eshop.interceptor;

import cn.hutool.jwt.JWTUtil;
import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lrz.eshop.common.webapi.ResultCode;
import com.lrz.eshop.util.RedisUtils;
import com.lrz.eshop.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * JWT token拦截器
 * @author 天天
 * @create 2023/2/28 15:49
 * @description
 */
public class JWTInterceptor implements HandlerInterceptor {

    // @Autowired
    // private HttpSession session;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle");
        //设置编码
        response.setCharacterEncoding("utf-8");
        // 从 http 请求头中取出 token
        // String token = request.getHeader("Authorization");
        String token = request.getHeader("Authorization");
        System.out.println("Authorization:" + token);//输出token
        if (token != null) {
            // 判断token是否被禁用

            //判断是否通过验证
            boolean result = TokenUtil.verify(token);
            if (result) {
                String id = TokenUtil.getIdByToken(token);
                System.out.println("通过拦截器");
                return true;
            }
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            JSONObject json = new JSONObject();
            // json.put("success", "false");
            json.put("msg", ResultCode.UNAUTHORIZED.getMessage());
            json.put("code", ResultCode.UNAUTHORIZED.getCode());
            response.getWriter().append(json.toJSONString());
            System.out.println("认证失败，token无效");
            // response.getWriter().write("50000");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500);
            return false;
        }
        return false;
    }
}
