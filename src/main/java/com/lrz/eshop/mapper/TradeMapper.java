package com.lrz.eshop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lrz.eshop.pojo.trade.Trade;
import com.lrz.eshop.pojo.user.Location;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author 天天
 * @create 2023/1/19 17:17
 * @description
 */
@Repository
public interface TradeMapper extends BaseMapper<Trade> {

    /**
     * 查询所有出售订单
     * @param sellerId
     * @return
     */
    // @Select("select * from trade where seller_id = #{sellerId}")
    // List<Trade> selectBySellerId(String sellerId);

    /**
     * 查询所有购买订单
     * @param buyerId
     * @return
     */
    @Select("select * from trade where buyer_id = #{buyerId} order by create_time desc")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "buyerId", column = "buyer_id"),
            @Result(property = "locationId", column = "location_id"),
            @Result(property = "location", column = "location_id", javaType = Location.class,
                    one = @One(select = "com.lrz.eshop.mapper.LocationMapper.selectById")
            ),
            @Result(property = "totalCount", column = "total_count"),
            @Result(property = "totalPrice", column = "total_price"),
            @Result(property = "totalDiscount", column = "total_discount"),
            @Result(property = "totalTransportationExpenses", column = "total_transportation_expenses"),
            @Result(property = "returnId", column = "return_id"),
            @Result(property = "commentId", column = "comment_id"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
            @Result(property = "state", column = "state"),
            @Result(property = "version", column = "version"),
            @Result(property = "tradeDetails", column = "id", javaType = List.class,
                    many = @Many(select = "com.lrz.eshop.mapper.TradeDetailMapper.selectByTradeId")
            ),
    })

    List<Trade> selectByBuyerId(String buyerId);


    /**
     * 查询特定状态的购买订单
     * @param buyerId
     * @param state
     * @return
     */
    @Select("select * from trade where buyer_id = #{buyerId} and state = #{state} order by create_time desc")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "buyerId", column = "buyer_id"),
            @Result(property = "locationId", column = "location_id"),
            @Result(property = "location", column = "location_id", javaType = Location.class,
                    one = @One(select = "com.lrz.eshop.mapper.LocationMapper.selectById")
            ),
            @Result(property = "totalCount", column = "total_count"),
            @Result(property = "totalPrice", column = "total_price"),
            @Result(property = "totalDiscount", column = "total_discount"),
            @Result(property = "totalTransportationExpenses", column = "total_transportation_expenses"),
            @Result(property = "returnId", column = "return_id"),
            @Result(property = "commentId", column = "comment_id"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
            @Result(property = "state", column = "state"),
            @Result(property = "version", column = "version"),
            @Result(property = "tradeDetails", column = "id", javaType = List.class,
                    many = @Many(select = "com.lrz.eshop.mapper.TradeDetailMapper.selectByTradeId")
            ),
    })
    List<Trade> selectByBuyerIdAndState(String buyerId, byte state);


    @Select("select * from trade where id = #{tradeId} and buyer_id = #{buyerId} and state = 1")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "buyerId", column = "buyer_id"),
            @Result(property = "locationId", column = "location_id"),
            @Result(property = "location", column = "location_id", javaType = Location.class,
                    one = @One(select = "com.lrz.eshop.mapper.LocationMapper.selectById")
            ),
            @Result(property = "totalCount", column = "total_count"),
            @Result(property = "totalPrice", column = "total_price"),
            @Result(property = "totalDiscount", column = "total_discount"),
            @Result(property = "totalTransportationExpenses", column = "total_transportation_expenses"),
            @Result(property = "returnId", column = "return_id"),
            @Result(property = "commentId", column = "comment_id"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
            @Result(property = "state", column = "state"),
            @Result(property = "version", column = "version"),
            @Result(property = "tradeDetails", column = "id", javaType = List.class,
                    many = @Many(select = "com.lrz.eshop.mapper.TradeDetailMapper.selectByTradeId")
            ),
    })
    Trade selectByTradeId(String tradeId, String buyerId);



}
