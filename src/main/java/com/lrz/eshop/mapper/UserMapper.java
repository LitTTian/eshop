package com.lrz.eshop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lrz.eshop.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 *
 * @author 天天
 * @create 2023/1/19 2:54
 * @description
 */

// 用于操作用户表,MyBaits会根据Mapper注解，动态实现UserMapper接口（实现类），动态代理技术
// Spring会自动创建UserMapper接口实现类对应的实例
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "pwd", column = "pwd"),
            @Result(property = "creditScore", column = "creditScore"),
            @Result(property = "cumulativeScore", column = "cumulativeScore"),
            @Result(property = "schoolId", column = "schoolId"),
            @Result(property = "avatarUrl", column = "avatarUrl"),
            @Result(property = "balance", column = "balance"),
            @Result(property = "createTime", column = "createTime"),
            @Result(property = "updateTime", column = "updateTime"),
            @Result(property = "version", column = "version"),
            @Result(property = "trades", column = "id", javaType = List.class,
                    many = @Many(select = "com.lrz.eshop.mapper.TradeMapper.selectByBuyerId")
            ),
    })
    List<User> selectAllUserAndTrades();
}
