package com.lrz.eshop.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * 消息=>交换机
 * @author 天天
 * @create 2023/5/6 11:31
 * @description
 */

@Slf4j
@Component
public class ConfirmCallback implements RabbitTemplate.ConfirmCallback {
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (!ack) {
            log.error("消息发送异常!");
        } else {
            log.info("消息成功发送到Exchange!");
        }
    }
}
