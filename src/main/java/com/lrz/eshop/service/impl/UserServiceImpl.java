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
    public List<User> verifyUser(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", user.getUsername());
        queryWrapper.eq("pwd", user.getPwd());
        return selectList(queryWrapper);
    }
}
