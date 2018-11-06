package com.lanou3g.observer;
//小刀
public class Knife implements Observer {

    @Override
    public void handleMessage(Subject subject,String message) {
        System.out.println("小刀:掉地上了");
        subject.remove(this);
    }
}
