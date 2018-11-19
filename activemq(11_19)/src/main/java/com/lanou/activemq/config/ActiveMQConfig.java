package com.lanou.activemq.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

@Configuration
public class ActiveMQConfig {

    public static final String QUEUE_SHORT_MESSAGE = "com.lanou.demo.SHORT_MESSAGE_QUEUE";

    public static final String TOPIC_ORDER_LIST = "com.lanou.demo.ORDER_LIST_TOPIC";


    // Queue 创建一个目的地的bean  一个地方发送消息 一个地方接收  放在队列中 等待客户端取
    @Bean
    public Queue shortMessageQueue() {
        // 命名规范
        System.out.println("hahah");
        return new ActiveMQQueue(QUEUE_SHORT_MESSAGE);
    }

    // Topic  目的地 一个地方发消息  多个地方接收
    @Bean
    public Topic orderTopic() {
        return new ActiveMQTopic(TOPIC_ORDER_LIST);
    }

    @Bean
    public JmsListenerContainerFactory<?> topicListenerContainer(ConnectionFactory activeMQConnectionFactory) {
        DefaultJmsListenerContainerFactory topicListenerContainer = new DefaultJmsListenerContainerFactory();
        topicListenerContainer.setPubSubDomain(true);
        topicListenerContainer.setConnectionFactory(activeMQConnectionFactory);
        return topicListenerContainer;
    }

    // 消息转换器
    @Bean
    public MessageConverter messageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        // 转成文本消息类型
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("type");
        return converter;
    }

}
