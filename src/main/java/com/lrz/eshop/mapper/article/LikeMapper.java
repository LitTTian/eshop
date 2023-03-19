package com.lrz.eshop.mapper.article;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lrz.eshop.pojo.article.Like;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 天天
 * @create 2023/3/15 16:24
 * @description
 */
@Repository
public interface LikeMapper extends BaseMapper<Like> {

    @Select("select count(*) from article_like where foreign_id = #{articleId} and type = 1 and is_like = 1")
    Integer selectLikeCountByArticleId(String articleId);

    @Select("select count(*) from article_like where foreign_id = #{articleId} and type = 1 and is_like = 2")
    Integer selectDislikeCountByArticleId(String articleId);

    @Select("select count(*) from article_like where foreign_id = #{commentId} and type = 2 and is_like = 1")
    Integer selectLikeCountByCommentId(String commentId);
    @Select("select count(*) from article_like where foreign_id = #{commentId} and type = 2 and is_like = 2")
    Integer selectDislikeCountByCommentId(String commentId);

    @Select("select count(*) from article_like where foreign_id = #{childCommentId} and type = 3 and is_like = 1")
    Integer selectLikeCountByChildCommentId(String childCommentId);

    @Select("select count(*) from article_like where foreign_id = #{childCommentId} and type = 3 and is_like = 2")
    Integer selectDislikeCountByChildCommentId(String childCommentId);

    // type 1:文章 2:评论 3:子评论
    @Select("select foreign_id from article_like where user_id = #{userId} and type = 2 and is_like = 1")
    List<String> selectLikeCommentIdsByUserId(String userId);

    // type 1:文章 2:评论 3:子评论
    @Select("select foreign_id from article_like where user_id = #{userId} and type = 3 and is_like = 1")
    List<String> selectLikeCommentChildIdsByUserId(String userId);

    // type 1:文章 2:评论 3:子评论
    @Select("select * from article_like where user_id = #{userId} and type = 1")
    List<Like> selectLikeArticleByUserId(String userId);

}
