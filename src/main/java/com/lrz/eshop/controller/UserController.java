package com.lrz.eshop.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.lrz.eshop.common.webapi.Result;
import com.lrz.eshop.common.webapi.ResultCode;
import com.lrz.eshop.pojo.User;
import com.lrz.eshop.service.AuthEmailService;
import com.lrz.eshop.service.OssService;
import com.lrz.eshop.service.UserService;
import com.lrz.eshop.service.dto.AuthUserDto;
import com.lrz.eshop.util.Encrypt;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 用户信息控制类
 * @author 天天
 * @create 2023/1/19 2:51
 * @description
 */
@Api(tags = "user-controller")
@RestController
@CrossOrigin
public class UserController {
    // @Autowired
    // private UserMapper userMapper;

    @Autowired
    private UserService userService;
    @Autowired
    private AuthEmailService authService;
    @Autowired
    private OssService ossService;

    /**
     * 查询所有用户
     * @return
     */
    @ApiOperation("查询所有的用户信息")
    @GetMapping("/user/query")
    public Result<?> query() {
        List<User> list = userService.selectList(null);
        System.out.println(list);
        return Result.success(list);
    }

    /**
     * 查询所有用户和购买记录
     * @return
     */
    @ApiOperation("查询所有用户和购买记录")
    @GetMapping("/user/queryAll")
    public Result<?> queryAll() {
        List<User> list = userService.selectAllUserAndTrades();
        System.out.println(list);
        return Result.success(list);
    }


    /**
     * 登陆时确认用户名密码，并存入session
     * @param user 用户名
     * @param session HttpSession
     * @return 成功或错误信息
     */
    @PostMapping("/user/verifyUser")
    public Result<?> verifyUser(@RequestBody User user, HttpSession session) {
        // 使用sha1加密
        user.setPwd(Encrypt.encodeWithSha1(user.getPwd()));
        List<User> userList = userService.verifyUser(user);
        if (userList.size() == 1) {
            // id 在 session中保存为String，为的是防止Long在存储雪花算法得到的id时丢失精度
            session.setAttribute("id", String.valueOf(userList.get(0).getId()));
        }
        return userList.size() == 1 ? Result.success(userList.get(0)) : Result.failed(ResultCode.LoginFailed);
    }

    /**
     * 注册时确认用户名密码，并存入session
     * @param user 用户名
     * @param session HttpSession
     * @return 用户对象
     */
    @PostMapping("/user/signUp")
    public Result<?> signUp(@RequestBody User user, HttpSession session) {
        // 使用sha1加密
        user.setPwd(Encrypt.encodeWithSha1(user.getPwd()));
        userService.insert(user);
        List<User> userList = userService.verifyUser(user);
        // id 在 session中保存为String，为的是防止Long在存储雪花算法得到的id时丢失精度
        session.setAttribute("id", String.valueOf(userList.get(0).getId()));
        return Result.success(userList.get(0));
    }


    /**
     * 查询用户名是否已经存在
     * @param username 用户名
     * @return true表示存在，false不存在
     */
    @PostMapping("/user/existUsername")
    public Result<?> existUsername(@RequestParam String username) {
         return Result.success(userService.existUsername(username));
    }


    /**
     * 为用户设置头像
     * @param file 头像图片
     * @param id 用户id
     * @return 头像地址
     */
    @PostMapping("/user/setAvatar")
    public Result<?> setAvatar(@RequestParam("file") MultipartFile file, @RequestParam("id") String id) {
        // System.out.println("avatar file:");
        // System.out.println(file);
        // System.out.println("username: ");
        // System.out.println(username);
        //  将头像上传云端
        String url = ossService.uploadFileAvatar(file, id);
        System.out.println("avatarUrl: " + url);
        // 修改数据库
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("id", id).set("avatar_url", url);
        userService.update(null, userUpdateWrapper);
        return Result.success(url);
    }

    @ApiOperation(value = "发送邮箱验证码")
    @PostMapping("/getemailcode")
    public Result<?> getEmailCode(@RequestParam String email) {
        return Result.success(authService.sendMailCode(email));
    }

    @ApiOperation(value = "注册")
    @PostMapping("/register")
    public Result<?> register(@RequestBody AuthUserDto authUserDto) {
        return Result.success(authService.register(authUserDto));
    }


}
