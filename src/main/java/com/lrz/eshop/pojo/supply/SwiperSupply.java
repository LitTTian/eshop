package com.lrz.eshop.pojo.supply;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("swiper_supply")
public class SwiperSupply {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
}
