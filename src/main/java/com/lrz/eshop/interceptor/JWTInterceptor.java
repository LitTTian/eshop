package com.lrz.eshop.interceptor;

import cn.hutool.jwt.JWTUtil;
import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lrz.eshop.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
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
        //判断状态
        if (request.getMethod().equals("OPTIONS")) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        //实例化
        // HandlerMethod handlerMethod = (HandlerMethod) handler;
        //返回此处理程序方法的方法，也就是取得接口的方法
        // Method method = handlerMethod.getMethod();

        //查看接口是否存在注释
        /* if (method.isAnnotationPresent(RolePermission.class)) {
            //取得接口的注解
            RolePermission annotation = method.getAnnotation(RolePermission.class);
            //获取login的访问权限，是登录完访问，还是不登录就可以访问
            if (!annotation.login()) {
                return true;
            }
        } */
        //设置编码
        response.setCharacterEncoding("utf-8");
        // 从 http 请求头中取出 token
        String token = request.getHeader("Authorization");
        System.out.println("Authorization:" + token);//输出token
        if (token != null) {
            //判断是否通过验证
            boolean result = TokenUtil.verify(token);
            //权限
            // String status = TokenUtil.getRoleByToken(request);
            //查看接口是否存在注释
            /* if (method.isAnnotationPresent(RolePermission.class)) {
                //取得接口的注解
                RolePermission annotation = method.getAnnotation(RolePermission.class);
                //获取权限
                String roleRolePermission = annotation.status();
                if (StringUtils.isBlank(roleRolePermission)) {
                    throw new Exception("接口权限获取失败");
                }
                //使用indexOf方法从头开始检索是否存在role,存在就返回位置,不存在就返回-1
                int i = roleRolePermission.indexOf(status);
                if (i == -1) {
                    throw new Exception("用户权限不足");
                }
            } */
            if (result) {
                String id = TokenUtil.getIdByToken(token);
                System.out.println("通过拦截器");
                request.getSession().setAttribute("id",id); // 设置id
                return true;
            }
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            JSONObject json = new JSONObject();
            // json.put("success", "false");
            json.put("msg", "认证失败，token无效");
            json.put("code", "404");
            response.getWriter().append(json.toJSONString());
            System.out.println("认证失败，token无效");
            // response.getWriter().write("50000");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500);
            return false;
        }
        return false;

        // old
        /* Map<String, Object> map = new HashMap<>();
        // 获取请求头中的令牌
        String token = request.getHeader("Authorization");
        try {
            TokenUtil.get(token);
            return true;
        }catch (SignatureVerificationException e) {
            e.printStackTrace();
            map.put("message", "无效签名");
        }catch (TokenExpiredException e) {
            e.printStackTrace();
            map.put("message", "token过期");
        }catch (AlgorithmMismatchException e) {
            e.printStackTrace();
            map.put("message", "token算法不一致");
        }catch (Exception e) {
            e.printStackTrace();
            map.put("message", "token无效！！");
        }
        map.put("state", false);
        String json = new ObjectMapper().writeValueAsString(map);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(json);
        return false; */

    }
}
