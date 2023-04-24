package com.lrz.eshop.pojo.common;


import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.lrz.eshop.pojo.product.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * table name:  star
 * @author 天天
 * @create 2023/1/19 17:18
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("star")
public class Star {
    @TableId(type = IdType.AUTO)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long userId;

    // 1.文章 2.商品 3.用户
    private Byte type;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long foreignId;

    @TableField(exist = false)
    private Object object; // 收藏的实体


    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @Version
    @TableField(value = "version", fill = FieldFill.INSERT)
    private int version;


}
