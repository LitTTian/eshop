package com.lrz.eshop.controller;

import com.lrz.eshop.common.webapi.Result;
import com.lrz.eshop.rabbitmq.producer.DelayMessageProducer;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 天天
 * @create 2023/5/11 12:41
 * @description
 */
@Api(tags = "delay-message-controller")
@RestController
@CrossOrigin
@RequestMapping("/api/delay-message")
@Slf4j
public class DelayMessageController {

    @Autowired
    DelayMessageProducer delayMessageProducer;
    @PostMapping("/send")
    public Result<?> send(@RequestParam String text, @RequestParam Integer delayTime) {
        delayMessageProducer.sendDelayPrintMessage(text, delayTime);
        log.info("延迟发送成功, text: {}, delayTime: {}", text, delayTime);
        return Result.success("发送成功");
    }


}
