package com.lrz.eshop.pojo.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户的销售信息
 * @author 天天
 * @create 2023/4/19 15:10
 * @description
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSellInfo {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id; // 用户的id

    private int modelSellCount; // 商品被购买的次数
    private int modelStaredCount; // 商品被收藏的次数
    private int modelCount; // 商品的数量



}
