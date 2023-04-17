package com.lrz.eshop.consumer;

import com.lrz.eshop.mapper.TradeMapper;
import com.lrz.eshop.pojo.trade.Trade;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

import static com.lrz.eshop.config.RabbitMQConfiguration.DELAY_QUEUE_NAME;


/**
 *
 * @author 天天
 * @create 2023/4/16 15:33
 * @description
 */

@Slf4j
@Component
public class DeadLetterQueueConsumer {

    @Autowired
    TradeMapper tradeMapper;

    // 监听死信队列
    @RabbitListener(queues = DELAY_QUEUE_NAME)
    public void receive(Message message, Channel channel) {
        // 获取消息
        String tradeId = new String(message.getBody());
        // 记录日志
        log.info("当前时间：{}，延迟队列接收到的订单编号：{}", LocalDateTime.now(), tradeId);
        Trade trade = tradeMapper.selectById(tradeId);
        if(trade != null && trade.getState().equals((short) 1)) {
            trade.setState((short) 6);
            tradeMapper.updateById(trade);
            // 记录操作日志
        }
    }

}
