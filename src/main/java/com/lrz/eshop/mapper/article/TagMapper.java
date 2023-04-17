package com.lrz.eshop.mapper.article;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lrz.eshop.pojo.article.Tag;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 天天
 * @create 2023/3/17 7:34
 * @description
 */
public interface TagMapper extends BaseMapper<Tag> {

    @Select("select name from tag where id = #{id}")
    String selectNameById(String id);

    @Select("select tag.*, a.counts from (select tag_id, count(tag_id) as counts from article_tag group by tag_id order by count(tag_id) desc limit 6) a, tag where tag.id = a.tag_id order by a.counts desc")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "counts", column = "counts")
    })
    List<Tag> selectHotTags();
}
