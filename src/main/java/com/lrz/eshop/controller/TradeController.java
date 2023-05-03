package com.lrz.eshop.controller;

import com.lrz.eshop.common.aop.DBLoggerAnnotation;
import com.lrz.eshop.common.webapi.Result;
import com.lrz.eshop.controller.dto.ExpressDto;
import com.lrz.eshop.controller.dto.TradeDTO;
import com.lrz.eshop.pojo.trade.Trade;
import com.lrz.eshop.service.TradeService;
import com.lrz.eshop.util.TokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    // @Autowired
    // private HttpSession session;

    @Autowired
    private HttpServletRequest request;

    // 提交订单

    /*@ApiOperation("下单")
    @PostMapping("/placeOrder")
    public Result<?> placeOrder(@RequestBody List<Trade> trades) {
        System.out.println(trades);
        List<Trade> tradeDBs = new ArrayList<>();
        for(Trade trade: trades) {
            Trade tradeDB = tradeService.placeOrder(trade);
            if (tradeDB == null) {
                return Result.operateFailed();
            }
            tradeDBs.add(tradeDB);
        }
        return Result.success("提交成功", tradeDBs);
    }    */
    @ApiOperation("下单")
    @PostMapping("/placeOrderList")
    public Result<?> placeOrder(@RequestBody List<TradeDTO> tradeDTOs) {
        System.out.println(tradeDTOs);
        List<Trade> tradeDBs = new ArrayList<>();
        // String userId = session.getAttribute("id").toString();
        String token = request.getHeader("Authorization");
        String userId = TokenUtil.getIdByToken(token);
        for(TradeDTO tradeDTO: tradeDTOs) {
            tradeDTO.setBuyerId(userId);
            Trade tradeDB = tradeService.placeOrder(tradeDTO);
            if (tradeDB == null) {
                return Result.operateFailed();
            }
            tradeDBs.add(tradeDB);
        }
        return Result.success("提交成功", tradeDBs);
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

    @ApiOperation("根据用户id查询所有购买订单")
    @PostMapping("/getTradesByUserId")
    public Result<?> getTradesByUserId() {
            // HttpSession session) {
        // String userId = session.getAttribute("id").toString();
        String token = request.getHeader("Authorization");
        String userId = TokenUtil.getIdByToken(token);
        tradeService.updateTradeByUserId(userId);
        return Result.success("查询成功", tradeService.getTradesByUserId(userId));
    }

    @ApiOperation("根据用户id查询所有销售订单")
    @PostMapping("/getTradesBySellerId")
    public Result<?> getTradesBySellerId() {
            // HttpSession session) {
        // String sellerId = session.getAttribute("id").toString();
        String token = request.getHeader("Authorization");
        String sellerId = TokenUtil.getIdByToken(token);
        List<Trade> trades = tradeService.getTradesBySellerId(sellerId);
        return Result.success("查询成功", trades);
    }


    @ApiOperation("根据订单id查询具体待支付订单")
    @PostMapping("/getTradeDetailByTradeId")
    public Result<?> getTradeDetailByTradeId(@RequestParam("tradeId") String tradeId) {
            // , HttpSession session) {
        // String userId = session.getAttribute("id").toString();
        String token = request.getHeader("Authorization");
        String userId = TokenUtil.getIdByToken(token);
        Trade trade = tradeService.getTradeDetailByTradeId(tradeId, userId);
        if(trade == null) {
            return Result.operateFailed();
        }
        return Result.success("查询成功", trade);
    }

    @ApiOperation("用户支付完，通过tradeId更新trade状态")
    @PostMapping("/payByTradeId")
    public Result<?> payByTradeId(@RequestParam("tradeId") String tradeId) {
            // , HttpSession session) {
        // String userId = session.getAttribute("id").toString();
        String token = request.getHeader("Authorization");
        String userId = TokenUtil.getIdByToken(token);
        Trade trade = tradeService.payByTradeId(userId, tradeId);
        if (trade == null) {
            return Result.operateFailed();
        }
        return Result.success("购买成功", trade);
    }

    @ApiOperation("取消订单")
    @PostMapping("/cancelTrade")
    public Result<?> cancelTrade(@RequestParam("tradeId") String tradeId) {
            // , HttpSession session) {
        // String userId = session.getAttribute("id").toString();
        String token = request.getHeader("Authorization");
        String userId = TokenUtil.getIdByToken(token);
        Trade trade = tradeService.verifyAndCancelTrade(userId, tradeId);
        if (trade == null) {
            return Result.operateFailed();
        }
        return Result.success("取消成功", trade);
    }

    @ApiOperation("确认收货")
    @PostMapping("/confirmReceipt")
    public Result<?> confirmReceipt(@RequestParam("tradeId") String tradeId) {
            // , HttpSession session) {
        // String userId = session.getAttribute("id").toString();
        String token = request.getHeader("Authorization");
        String userId = TokenUtil.getIdByToken(token);
        Trade trade = tradeService.confirmReceipt(userId, tradeId);
        if (trade == null) {
            return Result.operateFailed();
        }
        return Result.success("确认收货成功", trade);
    }

    @ApiOperation("卖家发货")
    @PostMapping("/deliverGoods")
    // @RequestParam("tradeId") String tradeId,
    // @RequestParam("expressCompany") String expressCompany,
    // @RequestParam("expressNumber") String expressNumber,
    public Result<?> deliverGoods(@RequestBody ExpressDto expressDto) {
                                  // HttpSession session) {
        // String sellerId = session.getAttribute("id").toString();
        String token = request.getHeader("Authorization");
        String sellerId = TokenUtil.getIdByToken(token);
        Trade trade = tradeService.deliverGoods(sellerId, expressDto.getTradeId(), expressDto.getExpressCompany(), expressDto.getExpressNumber());
        if (trade == null) {
            return Result.operateFailed();
        }
        return Result.success("发货成功", trade);
    }



}
