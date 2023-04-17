package com.lrz.eshop.producer;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import static com.lrz.eshop.config.RabbitMQConfiguration.DELAY_EXCHANGE_NAME;
import static com.lrz.eshop.config.RabbitMQConfiguration.DELAY_QUEUE_ROUTING_KEY;


/**
 * 延迟消息生产者
 * @author 天天
 * @create 2023/4/16 15:18
 * @description
 */

@Component
public class DelayMessageProducer {
    @Resource
    private RabbitTemplate rabbitTemplate;

    public void send(String orderId, Integer delayTime) {
        // 设置消息的过期时间
        rabbitTemplate.convertAndSend(DELAY_EXCHANGE_NAME, DELAY_QUEUE_ROUTING_KEY, orderId, msg -> {
            msg.getMessageProperties().setDelay(delayTime); // 设置延迟时间
            return msg;
        });
    }
}
