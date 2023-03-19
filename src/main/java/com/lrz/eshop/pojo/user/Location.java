package com.lrz.eshop.pojo.user;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户地址信息
 * @author 天天
 * @create 2023/3/7 23:25
 * @description
 */

@TableName("location")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    @TableId(type = IdType.AUTO)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long userId;

    private Integer seq;
    private String name;
    private String phone;

    private String province;
    private String city;
    private String district;
    private String street;
    private String detail;
    private String label;

    @TableField(fill = FieldFill.INSERT)
    private Short status; // 1表示可用，0表示移除

}
