package com.lrz.eshop.pojo.supply;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * table name:  sell
 * @author 天天
 * @create 2023/1/19 17:18
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sell")
public class Sell {
    @TableId(type = IdType.ASSIGN_ID)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long userId;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long supplyId;
    private Short state; // 正在卖（0）|已卖完|（1）|已下架（2）
    @TableField(fill = FieldFill.INSERT)
    Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    Date updateTime;
    @Version
    private Integer version;
}
