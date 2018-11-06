package com.lanou3g.observer;

public class BMW implements Observer {


    @Override
    public void handleMessage(Subject subject,String message) {
        System.out.println("宝马发动,打开车门");
    }
}
