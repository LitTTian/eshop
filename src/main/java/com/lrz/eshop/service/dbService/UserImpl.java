package com.lrz.eshop.service.dbService;

import com.lrz.eshop.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author 天天
 * @create 2023/1/19 2:55
 * @description
 */

@Service
public class UserImpl {
    @Autowired
    UserMapper userMapper;
}
