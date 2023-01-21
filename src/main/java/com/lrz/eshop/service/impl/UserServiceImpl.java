package com.lrz.eshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.lrz.eshop.mapper.UserMapper;
import com.lrz.eshop.pojo.User;
import com.lrz.eshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int update(User user, UpdateWrapper<User> userUpdateWrapper) {
        return 0;
    }



    @Override
    public int updateById(User user) {
        return 0;
    }

    @Override
    public int deleteById(String id) {
        return 0;
    }


    @Override
    public List<User> selectList(Wrapper<User> queryWrapper) {
        return null;
    }

    @Override
    public List<User> selectAllUserAndTrades() {
        return null;
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
    public List<User> verifyUser(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", user.getUsername());
        //加密后比较
        queryWrapper.eq("pwd", user.getPwd());
        return selectList(queryWrapper);
    }
}
