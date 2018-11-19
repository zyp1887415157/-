package com.lanou.activemq.service;

import com.lanou.activemq.config.ActiveMQConfig;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

// 专门用来接收消息的类
@Component
public class OrderHandler {

    @JmsListener(destination = ActiveMQConfig.TOPIC_ORDER_LIST,
    containerFactory = "topicListenerContainer")
    public void orderReceive(String message) {
        System.out.println("处理订单消息" + message);
    }

}
