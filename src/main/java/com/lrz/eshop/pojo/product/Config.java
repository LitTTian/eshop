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
 * @create 2023/3/1 17:06
 * @description
 */

@Data
@TableName("config")
@AllArgsConstructor
@NoArgsConstructor
public class Config {
    @TableId(type = IdType.AUTO)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long categoryId;

    private String name;
    private String value;

    @TableField(exist = false)
    private List<String> values;

}
