package com.lrz.eshop.controller;

import com.lrz.eshop.common.webapi.Result;
import com.lrz.eshop.mapper.LocationMapper;
import com.lrz.eshop.pojo.trade.Trade;
import com.lrz.eshop.service.TradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 天天
 * @create 2023/3/8 19:56
 * @description
 */

@Api(tags = "trade-controller")
@RestController
@CrossOrigin
@RequestMapping("/api/trade")
public class TradeController {


    @Autowired
    private TradeService tradeService;

    @Autowired
    private LocationMapper locationMapper;

    @ApiOperation("根据用户id查询所有订单")
    @PostMapping("/getTradesByUserId")
    public Result<?> getTradesByUserId(@RequestParam("userId") String userId) {
        return Result.success(tradeService.getTradesByUserId(userId));
    }

    @ApiOperation("根据订单id查询具体订单")
    @PostMapping("/getTradeDetailByTradeId")
    public Result<?> getTradeDetailByTradeId(@RequestParam("tradeId") String tradeId) {
        Trade trade = tradeService.getTradeDetailByTradeId(tradeId);
        if(trade == null) {
            return Result.failed();
        }
        return Result.success("查询成功", trade);
    }

    @ApiOperation("用户支付完，通过tradeId更新trade状态")
    @PostMapping("/payByTradeId")
    public Result<?> payByTradeId(@RequestParam("userId") String userId, @RequestParam("tradeId") String tradeId) {
        Trade trade = tradeService.payByTradeId(userId, tradeId);
        if (trade == null) {
            return Result.failed();
        }
        return Result.success("购买成功", trade);
    }






}
