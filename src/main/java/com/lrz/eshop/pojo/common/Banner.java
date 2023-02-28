package com.lrz.eshop.pojo.common;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * table name:  swiper_supply
 * @author 天天
 * @create 2023/1/19 17:19
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("banner")
public class Banner {

    @TableId(type = IdType.AUTO)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private String imgUrl;

    private short type;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long foreignId;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

}
