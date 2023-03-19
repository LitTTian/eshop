package com.lrz.eshop.mapper.article;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lrz.eshop.pojo.article.Tag;
import org.apache.ibatis.annotations.Select;

/**
 * @author 天天
 * @create 2023/3/17 7:34
 * @description
 */
public interface TagMapper extends BaseMapper<Tag> {

    @Select("select name from tag where id = #{id}")
    String selectNameById(String id);

}
