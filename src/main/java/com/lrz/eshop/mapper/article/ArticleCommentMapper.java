package com.lrz.eshop.mapper.article;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lrz.eshop.pojo.article.ArticleComment;
import com.lrz.eshop.pojo.user.UserSocialInfo;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 天天
 * @create 2023/3/15 16:21
 * @description
 */
@Repository
public interface ArticleCommentMapper extends BaseMapper<ArticleComment> {

    /**
     * 根据文章id查询评论
     * order: 评论时间倒序
     * @param articleId
     * @return
     */
    @Select("select * from article_comment where article_id = #{articleId} order by create_time desc")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "articleId", column = "article_id"),
            @Result(property = "user", column = "user_id", javaType = UserSocialInfo.class,
                    one = @One(select = "com.lrz.eshop.mapper.UserMapper.selectSocialInfoById")
            ),
            @Result(property = "content", column = "content"),
            @Result(property = "likes", column = "id", javaType = Integer.class,
                    one = @One(select = "com.lrz.eshop.mapper.article.LikeMapper.selectLikeCountByCommentId")
            ),
            @Result(property = "dislikes", column = "id", javaType = Integer.class,
                    one = @One(select = "com.lrz.eshop.mapper.article.LikeMapper.selectDislikeCountByCommentId")
            ),
            @Result(property = "children", column = "id", javaType = List.class,
                    one = @One(select = "com.lrz.eshop.mapper.article.ArticleCommentChildMapper.selectByMainCommentId")
            ),
            @Result(property = "createTime", column = "create_time"),
    })
    List<ArticleComment> selectByArticleId(String articleId);

    @Select("select * from article_comment where id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "articleId", column = "article_id"),
            @Result(property = "user", column = "user_id", javaType = UserSocialInfo.class,
                    one = @One(select = "com.lrz.eshop.mapper.UserMapper.selectSocialInfoById")
            ),
            @Result(property = "content", column = "content"),
            @Result(property = "likes", column = "id", javaType = Integer.class,
                    one = @One(select = "com.lrz.eshop.mapper.article.LikeMapper.selectLikeCountByCommentId")
            ),
            @Result(property = "dislikes", column = "id", javaType = Integer.class,
                    one = @One(select = "com.lrz.eshop.mapper.article.LikeMapper.selectDislikeCountByCommentId")
            ),
            @Result(property = "children", column = "id", javaType = List.class,
                    one = @One(select = "com.lrz.eshop.mapper.article.ArticleCommentChildMapper.selectByMainCommentId")
            ),
            @Result(property = "createTime", column = "create_time"),
    })
    ArticleComment selectDetailById(String id);
}
