package com.lrz.eshop.controller;

import com.lrz.eshop.common.aop.DBLoggerAnnotation;
import com.lrz.eshop.common.webapi.Result;
import com.lrz.eshop.common.webapi.ResultCode;
import com.lrz.eshop.pojo.user.User;
import com.lrz.eshop.controller.dto.UserDto;
import com.lrz.eshop.service.TradeService;
import com.lrz.eshop.service.UserService;
import com.lrz.eshop.util.RedisUtils;
import com.lrz.eshop.util.TokenUtil;
import io.swagger.annotations.Api;
import org.apache.http.protocol.HttpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.concurrent.TimeUnit;

/**
 * 登录控制器
 * @author 天天
 * @create 2023/4/26 12:47
 * @description
 */
@Api(tags = "login-controller")
@RestController
@CrossOrigin
@RequestMapping("/api/login")
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private TradeService tradeService;

    @Autowired
    private HttpSession session;

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private TokenUtil tokenUtil;

    /**
     * 登陆时确认用户名密码，并存入session
     * @param user 用户名
     * @return 成功或错误信息
     */
    @PostMapping("/verifyUser")
    @DBLoggerAnnotation(module="登录", operation = "用户登录")
    public Result<?> verifyUser(@RequestBody UserDto user) {
        // 密码已在前端加密过了
        User userDB = userService.verifyUser(user);
        if (userDB != null) {
            // id 在 session中保存为String，为的是防止Long在存储雪花算法得到的id时丢失精度
            // session.setAttribute("id", String.valueOf(userDB.getId()));
            // System.out.println("session id: " + session.getAttribute("id"));
            tradeService.updateTradeByUserId(String.valueOf(userDB.getId()));
            return Result.success("登录成功", userDB);
        }
        return Result.failed(ResultCode.LoginFailed);
    }

    @PostMapping("/getUserInfoByToken")
    @DBLoggerAnnotation(module="登录", operation = "通过token登录")
    public Result<?> getUserInfoByToken(@RequestParam(value = "token") String token) {
        if(redisUtils.isBlockedToken(token)) {
            return Result.failed(ResultCode.TokenIsBlocked);
        }
        User user = userService.getUserInfoByToken(token);
        if (user != null) {
            // session.setAttribute("id", String.valueOf(user.getId()));
            // System.out.println("session id: " + session.getAttribute("id"));
            tradeService.updateTradeByUserId(String.valueOf(user.getId())); // 被动更新超时订单
            return Result.success("登录成功", user);
        }
        return Result.failed(ResultCode.LoginFailed);
    }

    @PostMapping("/logout")
    @DBLoggerAnnotation(module="用户退出", operation = "通过token退出")
    // public Result<?> logout(@RequestParam String uId) {
    public Result<?> logout(@RequestParam(value = "token") String token) {
        System.out.println("logout token: " + token);
        long time = TokenUtil.getTokenExpireTime(token);
        redisUtils.addBlockedToken(token, time, TimeUnit.MILLISECONDS);
        // session.removeAttribute("id");
        session.invalidate();
        return Result.success("退出成功");
    }

}
