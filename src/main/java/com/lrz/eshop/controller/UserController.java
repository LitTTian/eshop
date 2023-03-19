package com.lrz.eshop.controller;

import cn.hutool.core.date.LocalDateTimeUtil;
import com.lrz.eshop.common.webapi.Result;
import com.lrz.eshop.common.webapi.ResultCode;
import com.lrz.eshop.mapper.article.LikeMapper;
import com.lrz.eshop.pojo.common.Star;
import com.lrz.eshop.pojo.user.Location;
import com.lrz.eshop.pojo.user.User;
import com.lrz.eshop.service.UserService;
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
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询所有用户
     * @return
     */
    @ApiOperation("查询所有的用户信息")
    @GetMapping("/query")
    public Result<?> query() {
        List<User> list = userService.selectList(null);
        // System.out.println(list);
        return Result.success(list);
    }

    /**
     * 查询所有用户和购买记录
     * @return
     */
    // @ApiOperation("查询所有用户和购买记录")
    // @GetMapping("/queryAll")
    // public Result<?> queryAll() {
    //     List<User> list = userService.selectAllUserAndTrades();
    //     // System.out.println(list);
    //     return Result.success(list);
    // }


    /**
     * 登陆时确认用户名密码，并存入session
     * @param user 用户名
     * @param session HttpSession
     * @return 成功或错误信息
     */
    @PostMapping("/verifyUser")
    public Result<?> verifyUser(@RequestBody User user, HttpSession session) {
        // 密码已在前端加密过了
        User userDB = userService.verifyUser(user);
        if (userDB != null) {
            // id 在 session中保存为String，为的是防止Long在存储雪花算法得到的id时丢失精度
            session.setAttribute("id", String.valueOf(userDB.getId()));
            return Result.success("登录成功", userDB);
        }
        return Result.failed(ResultCode.LoginFailed);
    }

    @PostMapping("/getUserInfoByToken")
    public Result<?> getUserInfoByToken(@RequestParam String token, HttpSession session) {
        User user = userService.getUserInfoByToken(token);
        if (user != null) {
            session.setAttribute("id", String.valueOf(user.getId()));
            return Result.success("登录成功", user);
        }
        return Result.failed(ResultCode.LoginFailed);
    }

    @GetMapping("/logout")
    // public Result<?> logout(@RequestParam String uId, HttpSession session) {
    public Result<?> logout(HttpSession session) {
        session.removeAttribute("id");
        return Result.success("退出成功");
    }

    /**
     * 注册时确认用户名密码，并存入session
     * @param user 用户名
     * @param session HttpSession
     * @return 用户对象
     */
    @PostMapping("/register")
    public Result<?> register(@RequestBody User user, HttpSession session) {
        // System.out.println(user);
        // 判断是否已存在用户
        if(userService.existEmail(user.getEmail())) {
            System.out.println("邮箱已存在");
            return Result.failed(ResultCode.EmailAlreadyExist);
        }

        if (userService.existUsername(user.getUsername())) {
            System.out.println("用户名已存在");
            return Result.failed(ResultCode.UsernameAlreadyExist);
        }
        // 使用sha1加密
        // user.setPassword(EncryptUtils.encodeWithSha1(user.setPassword()));
        userService.insert(user);
        User userDB = userService.verifyUser(user);
        // id 在 session中保存为String，为的是防止Long在存储雪花算法得到的id时丢失精度
        session.setAttribute("id", String.valueOf(userDB.getId()));
        return Result.success("注册成功", userDB);
    }


    /**
     * 查询用户名是否已经存在
     * @param username 用户名
     * @return {"message": "message", result: true/false}
     * true代表存在
     */
    @PostMapping("/existUsername")
    public Result<?> existUsername(@RequestParam String username) {
        return userService.existUsername(username)?
                Result.failed(ResultCode.UsernameAlreadyExist, true):
                Result.success("用户名可用", false);
    }

    /**
     * 查询邮箱是否已经存在
     * @param email 邮箱
     * @return {"message": "message", result: true/false}
     */
    @PostMapping("/existEmail")
    public Result<?> existEmail(@RequestParam String email) {
        return userService.existEmail(email)?
                Result.failed(ResultCode.EmailAlreadyExist, true):
                Result.success("邮箱可用", false);
    }


    /**
     * 为用户设置头像
     * @param file 头像图片
     * @param id 用户id
     * @return 头像地址
     */
    @PostMapping("/setAvatar")
    public Result<?> setAvatar(@RequestParam("file") MultipartFile file, @RequestParam("id") String id) {
        // 先查询出来才能使乐观锁生效
        User user = userService.selectUserInfoById(id);
        if(user == null) {
            return Result.failed();
        }
        //  将头像上传云端
        String url = userService.uploadUserAvatar(file, user);
        if (url == null) {
            return Result.failed();
        }
        // 修改数据库
        user.setAvatarUrl(url);
        userService.updateById(user);
        return Result.success("上传成功", url);
    }


    @ApiOperation("新增地址")
    @PostMapping("/addLocation")
    public Result< ? > addLocation(@RequestBody Location location) {
        if(location.getUserId() == null) {
            return Result.failed();
        }
        Location LocationDB = userService.addLocation(location);
        if(LocationDB == null) {
            return Result.failed();
        }
        return Result.success("添加地址成功", LocationDB);
    }

    @ApiOperation("移除地址，并不是真正删除地址记录，而是设置status为0")
    @PostMapping("/deleteLocation")
    public Result< ? > deleteLocation(@RequestParam("locationId") String locationId) {
        // 因为地址信息对订单信息有用，所以并不是真正删除地址记录，而是设置标志位
        Location location = userService.deleteLocation(locationId);
        if(location == null) {
            return Result.failed();
        }
        return Result.success("移除成功！", location);
    }


}
