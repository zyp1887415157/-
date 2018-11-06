package com.lanou3g.observer;

//小弟,随从
public class Servant implements Observer {

    @Override
    public void handleMessage(Subject subject,String message) {
        System.out.println("随从:大喊" + message);
    }
}
