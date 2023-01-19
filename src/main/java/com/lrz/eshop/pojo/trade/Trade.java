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
    @TableId(type = IdType.ASSIGN_ID)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long buyerId;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long supplyId;
    private Short state; // 已约定，未交易（0）|已付款，未收到货（1）|交易成功（2）|退货中（3）|退货完成（4）
    @TableField(fill = FieldFill.INSERT)
    Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    Date updateTime;
    @Version
    private Integer version;
}
