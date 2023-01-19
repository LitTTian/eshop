package com.lrz.eshop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lrz.eshop.pojo.trade.Trade;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**  
 *
 * @author 天天  
 * @create 2023/1/19 17:17  
 * @description    
 */
@Repository
public interface TradeMapper extends BaseMapper<Trade> {
    @Select("select * from trade where buyer_id = #{buyerId}")
    Trade selectByBuyerId(Long buyerId);
}
