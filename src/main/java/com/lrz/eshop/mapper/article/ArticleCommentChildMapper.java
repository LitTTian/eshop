package com.lrz.eshop.mapper.article;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lrz.eshop.pojo.article.ArticleCommentChild;
import com.lrz.eshop.pojo.user.User;
import com.lrz.eshop.pojo.user.UserSocialInfo;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 天天
 * @create 2023/3/15 16:35
 * @description
 */
@Repository
public interface ArticleCommentChildMapper extends BaseMapper<ArticleCommentChild> {

    @Select("select * from article_comment_child where main_comment_id = #{mainCommentId} order by create_time desc")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "articleId", column = "article_id"),
            @Result(property = "user", column = "user_id", javaType = UserSocialInfo.class,
                    one = @One(select = "com.lrz.eshop.mapper.user.UserInfoMapper.getUserSocialInfo")
            ),
            @Result(property = "mainCommentId", column = "main_comment_id"),
            @Result(property = "replyCommentId", column = "reply_comment_id"),
            // TODO 找到被回复者
            @Result(property = "replyUser", column = "{replyCommentId = reply_comment_id, afterMain = after_main}", javaType = UserSocialInfo.class,
                    one = @One(select = "com.lrz.eshop.mapper.article.ArticleCommentChildMapper.selectByReplyCommentId")
            ),


            @Result(property = "content", column = "content"),
            @Result(property = "afterMain", column = "after_main"),
            @Result(property = "likes", column = "id", javaType = Integer.class,
                    one = @One(select = "com.lrz.eshop.mapper.article.LikeMapper.selectLikeCountByChildCommentId")
            ),
            @Result(property = "dislikes", column = "id", javaType = Integer.class,
                    one = @One(select = "com.lrz.eshop.mapper.article.LikeMapper.selectDislikeCountByChildCommentId")
            ),
            @Result(property = "createTime", column = "create_time"),
    })
    List<ArticleCommentChild> selectByMainCommentId(String mainCommentId);

    @Select("<script> select * from user where id in (select user_id from <choose><when test='afterMain==true'> article_comment </when> <otherwise> article_comment_child </otherwise> </choose> where id = #{replyCommentId}) </script>")
    // @Select("<script> select user_id from <choose><when test='afterMain==true'> article_comment </when> <otherwise> article_comment_child </otherwise> </choose> where id = #{replyCommentId} </script>")
    // @Result(column = "user_id", javaType = UserSocialInfo.class,
    //         one = @One(select = "com.lrz.eshop.mapper.user.UserInfoMapper.getUserSocialInfo")
    // )
    UserSocialInfo selectByReplyCommentId(String replyCommentId, Boolean afterMain);


    @Select("select * from article_comment_child where id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "articleId", column = "article_id"),
            @Result(property = "user", column = "user_id", javaType = UserSocialInfo.class,
                    one = @One(select = "com.lrz.eshop.mapper.user.UserInfoMapper.getUserSocialInfo")
            ),
            @Result(property = "mainCommentId", column = "main_comment_id"),
            @Result(property = "replyCommentId", column = "reply_comment_id"),
            // TODO 找到被回复者
            @Result(property = "replyUser", column = "{replyCommentId = reply_comment_id, afterMain = after_main}", javaType = UserSocialInfo.class,
                    one = @One(select = "com.lrz.eshop.mapper.article.ArticleCommentChildMapper.selectByReplyCommentId")
            ),


            @Result(property = "content", column = "content"),
            @Result(property = "afterMain", column = "after_main"),
            @Result(property = "likes", column = "id", javaType = Integer.class,
                    one = @One(select = "com.lrz.eshop.mapper.article.LikeMapper.selectLikeCountByChildCommentId")
            ),
            @Result(property = "dislikes", column = "id", javaType = Integer.class,
                    one = @One(select = "com.lrz.eshop.mapper.article.LikeMapper.selectDislikeCountByChildCommentId")
            ),
            @Result(property = "createTime", column = "create_time"),
    })
    ArticleCommentChild selectDetailById(String id);



}
