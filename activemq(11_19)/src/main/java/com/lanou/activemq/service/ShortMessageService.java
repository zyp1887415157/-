package com.lanou.activemq.service;

import com.lanou.activemq.config.ActiveMQConfig;
import com.lanou.activemq.entity.MsgEntity;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Queue;


@Service
public class ShortMessageService {


    // 创建一个消息模板
    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    // 目的地队列的证明，我们要向这个队列发送消息
    @Resource
    private Queue shortMessageQueue;

    // 向特定的队列发送消息  消息为  “Hello 。。。”  格式为JSON格式  生产者
    public void sendVerifyCode() {
        MsgEntity msgEntity = new MsgEntity();
        msgEntity.setId(10L);
        msgEntity.setMobile("234234234545");
        msgEntity.setMessage("欠债还钱，天经地义");
        jmsMessagingTemplate.convertAndSend(shortMessageQueue, msgEntity);

    }


    // 接收消息  消费者
    @JmsListener(destination = ActiveMQConfig.QUEUE_SHORT_MESSAGE)
    public void receiveMessage(MsgEntity message) {
        System.out.println("接受到消息:" + " " + message);
    }
}
