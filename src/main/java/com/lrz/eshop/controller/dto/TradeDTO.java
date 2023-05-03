package com.lrz.eshop.controller.dto;

import lombok.Data;

import java.util.List;

/**
 * @author 天天
 * @create 2023/4/27 6:31
 * @description
 */
@Data
public class TradeDTO {
    private String locationId;
    private String sellerId;
    private String buyerId;
    private List<TradeDetailDTO> tradeDetailDTOs;
}

