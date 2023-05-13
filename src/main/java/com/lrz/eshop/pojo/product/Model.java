package com.lrz.eshop.pojo.product;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.lrz.eshop.pojo.common.Image;
import com.lrz.eshop.pojo.trade.Trade;
import com.lrz.eshop.pojo.user.UserSocialInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author 天天
 * @create 2023/2/26 13:44
 * @description
 */


@TableName("model")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Model {
    @TableId(type = IdType.AUTO)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long categoryId;

    @TableField(exist = false)
    private String categoryName;

    @TableField(exist = false)
    private Category category;

    private String title;

    private String advertisement;

    @TableField(exist = false)
    private double highPrice;

    @TableField(exist = false)
    private double lowPrice;

    @TableField(exist = false)
    private String coverImgUrl;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long sellerId;

    @TableField(exist = false)
    private UserSocialInfo seller;

    // private String configMain;

    // private String config1;
    // private String config2;
    // private String config3;
    // private String config4;
    // private String config5;

    @TableField(exist = false)
    private int starCount; // 收藏数

    @TableField(exist = false)
    private int sellCount; // 销量
    @TableField(exist = false)
    private int stock;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @Version
    @TableField(value = "version", fill = FieldFill.INSERT)
    private int version;

    @TableField(exist = false)
    private List<Image> images;

    @TableField(exist = false)
    private List<Product> products;


    @TableField(fill = FieldFill.INSERT)
    // true表示被移除，不接受查询
    private Boolean deleted;




}
