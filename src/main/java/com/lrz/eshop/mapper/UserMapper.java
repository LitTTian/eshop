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

    // 一定要注意自己封装的mapper方法写正确
    @Select("select * from user")
    @Results({
            // 这里的column是上面select查询的结果，即user表的默认column不再是驼峰！！！
            @Result(property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "email", column = "email"),
            @Result(property = "avatarUrl", column = "avatar_url"),
            @Result(property = "creditScore", column = "credit_score"),
            @Result(property = "cumulativeScore", column = "cumulative_score"),
            @Result(property = "balance", column = "balance"),
            @Result(property = "isSeller", column = "is_seller"),
            @Result(property = "shopId", column = "shop_id"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
            @Result(property = "version", column = "version"),
            @Result(property = "models", column = "id", javaType = List.class,
                    many = @Many(select = "com.lrz.eshop.mapper.ModelMapper.selectBySellerId")
            ),
            @Result(property = "buys", column = "id", javaType = List.class,
                    many = @Many(select = "com.lrz.eshop.mapper.TradeMapper.selectByBuyerId")
            ),
            @Result(property = "sells", column = "id", javaType = List.class,
                    many = @Many(select = "com.lrz.eshop.mapper.TradeMapper.selectBySellerId")
            ),
    })
    List<User> selectAllUserAndTrades();
}
