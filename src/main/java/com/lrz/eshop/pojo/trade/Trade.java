package com.lrz.eshop.pojo.trade;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**  
 * table name:  trade
 * @author 天天  
 * @create 2023/1/19 17:19  
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("trade")
public class Trade {
    @TableId(type = IdType.AUTO)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long sellerId;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long buyerId;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long productId;
    @TableField(fill = FieldFill.INSERT)
    Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    Date updateTime;

    private Short state; // 订单状态：1，下单，未付；2，已付，未收到；3，收到；4，退货中；5，交易完成；6，订单关闭

    @Version
    private Integer version;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long returnId;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long commentId;

}
