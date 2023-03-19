package com.lrz.eshop.mapper.article;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lrz.eshop.pojo.article.ArticleTag;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 天天
 * @create 2023/3/15 16:19
 * @description
 */
@Repository
public interface ArticleTagMapper extends BaseMapper<ArticleTag> {

    @Select("select * from article_tag where article_id = #{articleId}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "articleId", column = "article_id"),
            @Result(property = "tagId", column = "tag_id"),
            @Result(property = "name", column = "tag_id", javaType = String.class,
                    one = @One(select = "com.lrz.eshop.mapper.article.TagMapper.selectNameById")
            ),
            @Result(property = "seq", column = "seq"),
    })
    List<ArticleTag> selectByArticleId(String articleId);

    @Select("select max(seq) from article_tag where article_id = #{articleId}")
    Integer maxSeq(String articleId);

}
