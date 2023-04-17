package com.lrz.eshop.controller;

import com.lrz.eshop.common.webapi.Result;
import com.lrz.eshop.mapper.LocationMapper;
import com.lrz.eshop.pojo.trade.Trade;
import com.lrz.eshop.pojo.trade.TradeDetail;
import com.lrz.eshop.service.TradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 订单控制类
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

    // 提交订单

    @ApiOperation("下单")
    @PostMapping("/placeOrder")
    public Result<?> placeOrder(@RequestBody Trade trade) {
        System.out.println(trade);
        Trade tradeDB = tradeService.placeOrder(trade);
        if (tradeDB == null) {
            return Result.failed();
        }else {
            return Result.success("提交成功", tradeDB);
        }
    }

/*     @ApiOperation("提交订单")
    @PostMapping("/submitTrade")
    public Result<?> submitTrade(@RequestBody Trade trade) {
        Trade tradeDB = tradeService.insertTrade(trade);
        if (tradeDB == null) {
            return Result.failed();
        }else {
            return Result.success("提交成功", tradeDB);
        }
    } */

/*     @ApiOperation("提交订单详情")
    @PostMapping("/submitTradeDetailList")
    public Result<?> submitTradeDetailList(@RequestBody List<TradeDetail> tradeDetails) {
        List<TradeDetail> tradeDetailDBs = new ArrayList<>();
        if(tradeDetails == null || tradeDetails.size() == 0) {
            return Result.success(tradeDetails);
        }
        for(TradeDetail tradeDetail: tradeDetails) {
            TradeDetail tradeDetailDB = tradeService.insertTradeDetail(tradeDetail);
            if (tradeDetailDB != null) {
                tradeDetailDBs.add(tradeDetailDB);
            }
        }
        if (tradeDetailDBs.size() == 0) {
            return Result.failed();
        }else {
            return Result.success("提交成功", tradeDetailDBs);
        }
    } */

    @ApiOperation("根据用户id查询所有订单")
    @PostMapping("/getTradesByUserId")
    public Result<?> getTradesByUserId(@RequestParam("userId") String userId) {
        tradeService.updateTradeByUserId(userId);
        return Result.success(tradeService.getTradesByUserId(userId));
    }

    @ApiOperation("根据订单id查询具体订单")
    @PostMapping("/getTradeDetailByTradeId")
    public Result<?> getTradeDetailByTradeId(@RequestParam("tradeId") String tradeId,
                                             @RequestParam("userId") String userId) {
        Trade trade = tradeService.getTradeDetailByTradeId(tradeId, userId);
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


    @ApiOperation("取消订单")
    @PostMapping("/cancelTrade")
    public Result<?> cancelTrade(@RequestParam("userId") String userId, @RequestParam("tradeId") String tradeId) {
        Trade trade = tradeService.cancelTrade(userId, tradeId);
        if (trade == null) {
            return Result.failed();
        }
        return Result.success("取消成功", trade);
    }

    @ApiOperation("确认收货")
    @PostMapping("/confirmReceipt")
    public Result<?> confirmReceipt(@RequestParam("userId") String userId, @RequestParam("tradeId") String tradeId) {
        Trade trade = tradeService.confirmReceipt(userId, tradeId);
        if (trade == null) {
            return Result.failed();
        }
        return Result.success("确认收货成功", trade);
    }



}
