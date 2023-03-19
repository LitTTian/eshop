package com.lrz.eshop.pojo.article;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 天天
 * @create 2023/3/15 16:24
 * @description
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("article_like")
public class Like {
    @TableId(type = IdType.AUTO)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long userId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long foreignId;

    // 1：表示文章；2：表示主评论; 3：表示子评论
    private Short type;

    // 0:表示取消点赞；1：表示点赞；2：表示踩
    private Short isLike;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @Version
    @TableField(value = "version", fill = FieldFill.INSERT)
    private Integer version;



}
