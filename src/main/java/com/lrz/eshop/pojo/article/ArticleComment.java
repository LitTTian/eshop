package com.lrz.eshop.pojo.article;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.lrz.eshop.pojo.user.User;
import com.lrz.eshop.pojo.user.UserSocialInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * 文章下方的独立评论
 * @author 天天
 * @create 2023/3/15 15:04
 * @description
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("article_comment")
public class ArticleComment {
    @TableId(type = IdType.AUTO)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long articleId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long userId;
    // 根据userId查询出来的用户信息
    // 必须包括：id、头像、昵称
    @TableField(exist = false)
    private UserSocialInfo user;

    private String content;

    // 根据articleCommentId查询出来的like和dislike的数量
    // foreign_id = article_comment.id, type = 3
    @TableField(exist = false)
    private Integer likes;
    @TableField(exist = false)
    private Integer dislikes;

    // 根据articleCommentId查询出来的子评论的数量
    List<ArticleCommentChild> children;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;


}
