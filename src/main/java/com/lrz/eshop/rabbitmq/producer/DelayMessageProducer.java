package com.lrz.eshop.rabbitmq.producer;


import com.lrz.eshop.rabbitmq.ConfirmCallback;
import com.lrz.eshop.rabbitmq.ReturnCallback;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import static com.lrz.eshop.rabbitmq.RabbitMQConfiguration.*;


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

    @Autowired
    private ConfirmCallback confirmCallback;

    // @Autowired
    // private ReturnCallback returnCallback;



    public void sendTradeValidator(String orderId, Integer delayTime) {
        /**
         * 1.消息发送失败后，会进入到ConfirmCallback回调函数中
         * 2.消息发送成功后，会进入到ReturnCallback回调函数中
         * 3.消息发送成功后，会进入到DeadLetterQueueConsumer监听器中
         * 注意：yml需要配置 publisher-returns: true
         */

        rabbitTemplate.setMandatory(true); // 开启失败通知
        rabbitTemplate.setConfirmCallback(confirmCallback); // 消费者确认收到消息后，手动ack回执回调处理
        // rabbitTemplate.setReturnCallback(returnCallback); // 消息投递到队列失败回调处理
        // 设置消息的过期时间
        rabbitTemplate.convertAndSend(DELAY_EXCHANGE_NAME, DELAY_ORDER_QUEUE_ROUTING_KEY, orderId, msg -> {
            msg.getMessageProperties().setDelay(delayTime); // 设置延迟时间
            return msg;
        });
    }

    public void sendDelayPrintMessage(String text, Integer delayTime) {
        rabbitTemplate.setConfirmCallback(confirmCallback); // 消费者确认收到消息后，手动ack回执回调处理
        // rabbitTemplate.setReturnCallback(returnCallback);
        rabbitTemplate.convertAndSend(DELAY_EXCHANGE_NAME, DELAY_PRINT_QUEUE_ROUTING_KEY, text, msg -> {
            msg.getMessageProperties().setDelay(delayTime); // 设置延迟时间
            return msg;
        });
    }
}
