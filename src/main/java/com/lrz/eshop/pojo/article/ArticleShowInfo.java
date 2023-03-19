package com.lrz.eshop.pojo.article;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.lrz.eshop.pojo.product.Category;
import com.lrz.eshop.pojo.user.UserSocialInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 天天
 * @create 2023/3/19 13:41
 * @description
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleShowInfo {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long userId;

    @TableField(exist = false)
    private UserSocialInfo user;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long categoryId;

    @TableField(exist = false)
    private Category category;

    private String title;

    private String abstracts;

    @TableField(exist = false)
    private String coverImageUrl;

    @TableField(fill = FieldFill.INSERT)
    private Integer watches;

    @TableField(exist = false)
    private Integer stars;

    @TableField(exist = false)
    private Integer likes;
    // isLike = 0,
    @TableField(exist = false)
    private Integer dislikes;

    private Date createTime;

}
