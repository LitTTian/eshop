package com.lrz.eshop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lrz.eshop.pojo.product.Config;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 天天
 * @create 2023/3/1 18:17
 * @description
 */
@Repository
public interface ConfigMapper extends BaseMapper<Config> {
    // @Select("select value from config where category_id = #{categoryId} AND name = #{name}")
    // List<String> values(String categoryId, String name);

    @Select("select distinct name from config where category_id = #{categoryId}")
    List<String> configNames(String categoryId);

}
