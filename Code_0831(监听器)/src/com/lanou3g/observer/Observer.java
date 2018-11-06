package com.lanou3g.observer;

// 观察者  用来接收并处理这个消息
public interface Observer {

    void handleMessage(Subject subject,String message);
}
