package com.lrz.eshop.pojo.common;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 天天
 * @create 2023/3/2 22:28
 * @description
 */

@TableName("queryTop")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryTop {
    @TableId(type = IdType.AUTO)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long modelId;


    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @TableField(exist = false)
    private Long categoryId;

    @TableField(exist = false)
    private Long lowPrice;



}
