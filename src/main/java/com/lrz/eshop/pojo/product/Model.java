package com.lrz.eshop.pojo.product;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.lrz.eshop.pojo.trade.Trade;
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

    private String title;

    private String advertisement;

    private String coverImgUrl;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long sellerId;

    // private String configMain;

    // private String config1;
    // private String config2;
    // private String config3;
    // private String config4;
    // private String config5;

    private int starCount;

    private int sellCount;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @Version
    @TableField(value = "version", fill = FieldFill.INSERT)
    private int version;

    @TableField(exist = false)
    private List<Product> products;




}
