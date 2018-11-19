package com.lanou.activemq.service;

import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Topic;

@Service
public class OrderService {

    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Resource
    private Topic orderTopic;

    public String disposeOrder() {
        jmsMessagingTemplate.convertAndSend(orderTopic, "处理订单" + Math.random());
        return "订单处理完成";
    }
}
