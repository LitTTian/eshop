package com.lrz.eshop.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * 交换机=>队列
 * @author 天天
 * @create 2023/5/6 11:33
 * @description
 */


@Slf4j
@Component
public class ReturnCallback implements RabbitTemplate.ReturnCallback {
    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        log.info("==========================log start==========================");
        log.info("ReturnCallback [消息从交换机到队列失败]");
        log.info("消息主体 message : "+message);
        log.info("回复码 replyCode : "+replyCode);
        log.info("描述："+replyText);
        log.info("消息使用的交换器 exchange : "+exchange);
        log.info("消息使用的路由键 routing : "+routingKey);
        log.info("===========================log end===========================");
    }
}
