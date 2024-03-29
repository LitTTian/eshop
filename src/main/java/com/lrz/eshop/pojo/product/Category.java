package com.lrz.eshop.pojo.product;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 天天
 * @create 2023/2/26 14:25
 * @description
 */

@TableName("category")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @TableId(type = IdType.AUTO)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private String name;
    // private String configMain;
    // private String config1;
    // private String config2;
    // private String config3;
    // private String config4;
    // private String config5;

    @TableField(exist = false)
    private List<Config> configs;

    // 用于存放弹出层的model数据
    @TableField(exist = false)
    private List<Model> models;


}
