package com.lrz.eshop.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.lrz.eshop.common.webapi.Result;
import com.lrz.eshop.common.webapi.ResultCode;
import com.lrz.eshop.mapper.TradeMapper;
import com.lrz.eshop.mapper.UserMapper;
import com.lrz.eshop.pojo.User;
import com.lrz.eshop.service.OssService;
import com.lrz.eshop.util.Encrypt;
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
@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OssService ossService;

    /*@GetMapping("/user/query")
    public Result<?> query() {
        List<User> list = userMapper.selectList(null);
        System.out.println(list);
        return Result.success("查询所有用户");
    }

    @GetMapping("/user/queryAll")
    public Result<?> queryAll() {
        List<User> list = userMapper.selectAllUserAndTrades();
        System.out.println(list);
        return Result.success("查询所有用户和购买记录");
    }*/

    /**
     * 根据用户名请求返回用户信息
     * @param id 用户id
     * @return 用户或错误信息
     */
//    @ApiOperation("根据用户名返回用户信息")
    @PostMapping("/user/queryId")
    public Result<?> queryId(@RequestParam String id) {
        System.out.println("In queryUsername:" + id);
        User user =  userMapper.selectById(id);
        return user == null ? Result.failed(ResultCode.UserNotExist) : Result.success(user);
    }

    /**
     * 登陆时确认用户名密码，并存入session
     * @param user 用户名
     * @param session HttpSession
     * @return 成功或错误信息
     */
    @PostMapping("/user/verifyUser")
    public Result<?> verifyUser(@RequestBody User user, HttpSession session) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", user.getUsername());
        //加密后比较
        queryWrapper.eq("pwd", Encrypt.encodeWithSha1(user.getPwd()));
        List<User> userList = userMapper.selectList(queryWrapper);
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
        //sha1加密
        user.setPwd(Encrypt.encodeWithSha1(user.getPwd()));
        userMapper.insert(user);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", user.getUsername());
        List<User> userList = userMapper.selectList(queryWrapper);
        // id 在 session中保存为String，为的是防止Long在存储雪花算法得到的id时丢失精度
        session.setAttribute("id", String.valueOf(userList.get(0).getId()));
        return Result.success(userList.get(0));
    }

//    @PostMapping("/user/id")
//    public Result<?> queryUserId(@RequestBody User user) {
//        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("username", user.getUsername());
//        List<User> userList = userMapper.selectList(queryWrapper);
//        return userList.size() == 0 ? Result.error("-1", "Found no users in database") : Result.success(userList.get(0).getId());
//    }

    /**
     * 查询用户名是否已经存在
     * @param username 用户名
     * @return true表示存在，false不存在
     */
    @PostMapping("/user/queryUsername")
    public Result<?> queryUsername(@RequestParam String username) {
        Long cnt = userMapper.selectCount(
                new QueryWrapper<User>().eq("username", username)
        );
        // System.out.println(cnt);
        return Result.success(cnt != 0);
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
        userMapper.update(null, userUpdateWrapper);
        return Result.success(url);
    }


}
