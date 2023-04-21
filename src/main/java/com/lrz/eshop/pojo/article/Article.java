package com.lrz.eshop.pojo.article;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.lrz.eshop.pojo.common.Image;
import com.lrz.eshop.pojo.product.Category;
import com.lrz.eshop.pojo.user.User;
import com.lrz.eshop.pojo.user.UserSocialInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.connection.ReactiveHashCommands;

import java.util.Date;
import java.util.List;

/**
 * @author 天天
 * @create 2023/3/15 14:51
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("article")
public class Article {
    @TableId(type = IdType.AUTO)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long userId;
    // 通过userId查询出的UserSocialInfo
    // 必须包括：头像、昵称、性别、个性签名
    @TableField(exist = false)
    private UserSocialInfo user;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long categoryId;

    @TableField(exist = false)
    private Category category;

    private String title;

    private String abstracts;

    private String content;

    @TableField(exist = false)
    private String coverImageUrl;
    // 查询出来的图片数组
    // type = 4， foreign_id = article.id
    @TableField(exist = false)
    private List<Image> images;

    // 查询出来的标签数组
    // article_tag.article_id = article.id
    @TableField(exist = false)
    private List<ArticleTag> articleTags;

    @TableField(fill = FieldFill.INSERT)
    private Integer watches;

    @TableField(exist = false)
    private Integer stars; // 收藏数,需要根据articleId查询出来

    // 根据articleId查询出来的like和dislike的数量
    // foreign_id = article.id, type = 2
    // isLike = 1,
    @TableField(exist = false)
    private Integer likes;
    // isLike = 0,
    @TableField(exist = false)
    private Integer dislikes;

    @TableField(exist = false)
    private Integer commentCount;

    // 根据articleId查询出来的评论
    @TableField(exist = false)
    List<ArticleComment> articleComments;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @Version
    @TableField(value = "version", fill = FieldFill.INSERT)
    private int version;

    // 1：public 2：private 3：delete
    @TableField(fill = FieldFill.INSERT)
    private byte type;

}
