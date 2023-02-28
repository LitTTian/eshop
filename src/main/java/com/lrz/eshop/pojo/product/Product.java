package com.lrz.eshop.pojo.product;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.lrz.eshop.pojo.common.Image;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 天天
 * @create 2023/2/26 13:39
 * @description
 */

@TableName("product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @TableId(type = IdType.AUTO)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long categoryId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long modelId;

    private Float price;

    private String description;

    private int seq;

    private String configMain;
    private String config1;
    private String config2;
    private String config3;
    private String config4;
    private String config5;
    private String mainImgUrl;
    private String gift;
    private String stackCnt;
    private String sellCnt;
    private int onSale;

    @TableField(exist = false)
    private List<Image> images;


}
