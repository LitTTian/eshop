package com.lrz.eshop.pojo.article;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.lrz.eshop.pojo.user.User;
import com.lrz.eshop.pojo.user.UserSocialInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 文章下方的独立评论的子评论
 * @author 天天
 * @create 2023/3/15 15:15
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("article_comment_child")
public class ArticleCommentChild {
    @TableId(type = IdType.AUTO)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long userId;
    // 根据userId查询出来的用户信息
    // 必须包括：id、头像、昵称
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long articleId;
    @TableField(exist = false)
    private UserSocialInfo user;

    // 从属于哪一个主评论
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long mainCommentId;

    // 回复哪一条评论
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long replyCommentId;


    // 还需要通过replyCommentId查询出来的被回复的用户信息
    // 必须包括：id、昵称
    @TableField(exist = false)
    private UserSocialInfo replyUser;



    private String content;

    // 是否回复的是主评论
    // true表示回复的是主评论
    // false表示回复的是子评论
    private Boolean afterMain;

    // 根据articleCommentId查询出来的like和dislike的数量
    // foreign_id = article_comment_child.id, type = 3
    @TableField(exist = false)
    private Integer likes;
    @TableField(exist = false)
    private Integer dislikes;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

}
