package com.lrz.eshop.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * RabbitMQ配置类
 * @author 天天
 * @create 2023/4/16 14:01
 * @description
 */

@Configuration
public class RabbitMQConfiguration {

    // 声明 1个路由key 1个队列 1个交换机
    public static final String DELAY_EXCHANGE_NAME = "delay.exchange"; // 延迟交换机
    public static final String DELAY_ORDER_QUEUE_NAME = "delay.order.queue"; // 延迟队列
    // 延迟队列路由key
    public static final String DELAY_ORDER_QUEUE_ROUTING_KEY = "delay.order.queue.routing.key";
    public static final String DELAY_PRINT_QUEUE_NAME = "delay.print.queue"; // 延迟打印控制台
    // 延迟队列路由key
    public static final String DELAY_PRINT_QUEUE_ROUTING_KEY = "delay.print.queue.routing.key";


    // 声明延迟交换器
    @Bean("delayExchange")
    public CustomExchange directExchange() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-delayed-type", "direct");
        return new CustomExchange(DELAY_EXCHANGE_NAME, "x-delayed-message", true, false, args);
    }


    // 声明延迟队列，不设置TTL存活时间，并且绑定死信交换机
    @Bean("delayOrderQueue")
    public Queue delayOrderQueue() {
        return new Queue(DELAY_ORDER_QUEUE_NAME);
    }


    // 声明延迟队列的绑定关系
    @Bean
    public Binding delayBindingA(@Qualifier("delayOrderQueue") Queue queue,
                                 @Qualifier("delayExchange") CustomExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(DELAY_ORDER_QUEUE_ROUTING_KEY).noargs();
    }

    // 打印控制台队列
    @Bean("delayPrintQueue")
    public Queue delayPrintQueue() {
        return new Queue(DELAY_PRINT_QUEUE_NAME);
    }
    @Bean
    public Binding delayBindingB(@Qualifier("delayPrintQueue") Queue queue,
                                 @Qualifier("delayExchange") CustomExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(DELAY_PRINT_QUEUE_ROUTING_KEY).noargs();
    }







}
