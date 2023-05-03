package com.lrz.eshop.controller.dto;

import lombok.Data;

/**
 * @author 天天
 * @create 2023/4/27 6:10
 * @description
 */
@Data
public class TradeDetailDTO {
    private String productId;
    private int count;
    private String imageUrl;
}
