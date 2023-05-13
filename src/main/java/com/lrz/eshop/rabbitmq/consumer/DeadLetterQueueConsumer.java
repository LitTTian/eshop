package com.lrz.eshop.rabbitmq.consumer;

import com.lrz.eshop.mapper.trade.TradeMapper;
import com.lrz.eshop.pojo.trade.Trade;
import com.lrz.eshop.service.TradeService;
import com.lrz.eshop.util.HttpContextUtils;
import com.lrz.eshop.util.NetworkUtils;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDateTime;

import static com.lrz.eshop.rabbitmq.RabbitMQConfiguration.DELAY_ORDER_QUEUE_NAME;
import static com.lrz.eshop.rabbitmq.RabbitMQConfiguration.DELAY_PRINT_QUEUE_NAME;


/**
 * 延迟消息消费者
 * @author 天天
 * @create 2023/4/16 15:33
 * @description
 */

@Slf4j
@Component
public class DeadLetterQueueConsumer {

    @Autowired
    TradeMapper tradeMapper;

    @Autowired
    TradeService tradeService;

    // 监听死信队列
    @RabbitListener(queues = DELAY_ORDER_QUEUE_NAME)
    public void receiveTradeValidate(Message message, Channel channel) throws IOException {
        try {
            // 获取消息
            String tradeId = new String(message.getBody());
            // 记录日志
            log.info("当前时间：{}，延迟队列接收到的订单编号：{}", LocalDateTime.now(), tradeId);
            Trade trade = tradeMapper.selectById(tradeId);
            tradeService.updateTradeState(trade);
            // 发送确认消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            // 记录操作日志
            // ...
        } catch (IOException e) {
            if (message.getMessageProperties().getRedelivered()) {
                log.error("消息已重复处理失败,拒绝再次接收...");
                channel.basicReject(message.getMessageProperties().getDeliveryTag(), false); // 拒绝消息
            } else {
                log.error("消息即将再次返回队列处理...");
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
            }
        }
    }


    @RabbitListener(queues = DELAY_PRINT_QUEUE_NAME)
    public void receivePrintMessage(Message message, Channel channel) throws IOException {
        // 取消自动ack
        // channel.basicQos(1);
        try {
            String text = new String(message.getBody());
            System.out.println("当前时间：" + LocalDateTime.now());
            System.out.println(message);
            System.out.println(text);
            // 发送确认消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            // 记录操作日志
            // ...
        } catch (IOException e) {
            if (message.getMessageProperties().getRedelivered()) {
                log.error("消息已重复处理失败,拒绝再次接收...");
                channel.basicReject(message.getMessageProperties().getDeliveryTag(), false); // 拒绝消息
            } else {
                log.error("消息即将再次返回队列处理...");
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
            }
        }
    }

}
