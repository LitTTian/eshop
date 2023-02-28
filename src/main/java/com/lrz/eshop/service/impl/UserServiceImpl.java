package com.lrz.eshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.lrz.eshop.common.webapi.Result;
import com.lrz.eshop.mapper.UserMapper;
import com.lrz.eshop.pojo.User;
import com.lrz.eshop.service.OssService;
import com.lrz.eshop.service.UserService;
import com.lrz.eshop.util.ImageNameUtil;
import com.lrz.eshop.util.RedisUtils;
import com.lrz.eshop.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 调用UserMapper操作数据库
 * @author 天天
 * @create 2023/1/21 2:39
 * @description
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    OssService ossService;

    // @Autowired
    // RedisUtils redisUtils;

    // @Autowired
    // private TokenUtil tokenUtil;


    @Override
    public User selectById(String id) {
        return userMapper.selectById(id);
    }

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int update(User user, UpdateWrapper<User> userUpdateWrapper) {
        return userMapper.update(user, userUpdateWrapper);
    }



    @Override
    public int updateById(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public int deleteById(String id) {
        return userMapper.deleteById(id);
    }


    @Override
    public List<User> selectList(Wrapper<User> queryWrapper) {
        return userMapper.selectList(queryWrapper);
    }

    @Override
    public List<User> selectAllUserAndTrades() {
        return userMapper.selectAllUserAndTrades();
    }

    @Override
    public Boolean exist(Wrapper<User> queryWrapper) {
        return userMapper.exists(queryWrapper);
    }

    @Override
    public Boolean existUsername(String username) {
        return exist(new QueryWrapper<User>().eq("username", username));
    }

    @Override
    public Boolean existEmail(String email) {
        return exist(new QueryWrapper<User>().eq("email", email));
    }

    @Override
    public Boolean existId(String id) {
        return exist(new QueryWrapper<User>().eq("id", id));
    }

    @Override
    public User verifyUser(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", user.getUsername());
        queryWrapper.eq("password", user.getPassword());
        List<User> users = selectList(queryWrapper);
        User sUser = users.get(0);
        if(sUser == null) {
            return null;
        }else {
            String token = UUID.randomUUID().toString();
            // redisUtils.set(token, sUser.getId(), 60 * 60 * 24 * 7,  TimeUnit.SECONDS);
            // String token = tokenUtil.generateToken(sUser);
            sUser.setToken(token);
            sUser.setPassword(null);
            return sUser;
        }
    }

    @Override
    public String uploadUserAvatar(MultipartFile file, User user) {
        String originPath = user.getAvatarUrl();
        if(originPath != null && !originPath.equals("")) {
            if(!ossService.deleteFile(originPath)) {
                return null;
            }
        }
        // users/123456/avatar/2021/01/19/123456/avatar/db39a8379db54ae0a92e82f498751589.jpg
        String path = "users/" + user.getId() + "/avatar/" + ImageNameUtil.getImgName(file.getOriginalFilename());
        // 成功返回：https://oss-cn-hangzhou.aliyuncs.com/images/users/123456/avatar/db39a8379db54ae0a92e82f498751589.jpg
        // 否则返回：null
        return ossService.uploadFile(file, path);
    }


}
