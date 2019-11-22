package com.example.demo.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Topic配置
 * @author sheng
 * @date 2019/11/21
 */
//@Configuration
public class TopicRabbitConfig {

    final static String message = "topic.message";

    @Bean
    public Queue queueMessage() {
        // 创建队列
        return new Queue(TopicRabbitConfig.message);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("topicExchange");
    }

    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
        // 将对列绑定到Topic交换器 采用#的方式
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }

}
