package com.lrz.eshop.pojo.trade;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.lrz.eshop.pojo.product.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 天天
 * @create 2023/3/8 6:39
 * @description
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("trade_detail")
public class TradeDetail {
    @TableId(type = IdType.AUTO)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long tradeId;

    private int seq;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @TableField(exist = false)
    private Long sellerId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long productId;

    private Product product;

    private float price;

    private float discount;
    private int count;
    private int transportationExpenses;
    private String imageUrl;

}
