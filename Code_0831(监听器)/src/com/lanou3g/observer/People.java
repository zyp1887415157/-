package com.lanou3g.observer;

public class People implements Observer {
    @Override
    public void handleMessage(Subject subject,String message) {
        System.out.println("路人跑了");
        subject.remove(this);
    }
}
