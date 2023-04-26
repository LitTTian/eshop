package com.lrz.eshop.pojo.trade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 天天
 * @create 2023/4/26 14:41
 * @description
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpressDto {
    private String tradeId;
    private String expressCompany;
    private String expressNumber;
}
