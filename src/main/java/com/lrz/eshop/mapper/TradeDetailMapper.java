package com.lrz.eshop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lrz.eshop.pojo.product.Product;
import com.lrz.eshop.pojo.trade.Trade;
import com.lrz.eshop.pojo.trade.TradeDetail;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 天天
 * @create 2023/3/8 7:01
 * @description
 */
public interface TradeDetailMapper extends BaseMapper<TradeDetail> {

    /**
     * 查询所有出售订单
     * @param sellerId
     * @return
     */
    @Select("select * from trade_detail where seller_id = #{sellerId}")
    List<TradeDetail> selectBySellerId(String sellerId);

    @Select("select * from trade_detail where trade_id = #{tradeId} order by seq")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "tradeId", column = "trade_id"),
            @Result(property = "seq", column = "seq"),
            @Result(property = "sellerId", column = "sellerId"),
            @Result(property = "productId", column = "product_id"),
            @Result(property = "product", column = "product_id", javaType = Product.class,
                    one = @One(select = "com.lrz.eshop.mapper.ProductMapper.selectDetailById")
            ),
            @Result(property = "price", column = "price"),
            @Result(property = "discount", column = "discount"),
            @Result(property = "count", column = "count"),
            @Result(property = "transportationExpenses", column = "transportation_expenses"),
            @Result(property = "imageUrl", column = "image_url"),
    })
    List<TradeDetail> selectByTradeId(String tradeId);


}
