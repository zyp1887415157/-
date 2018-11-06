package com.lanou3g;

import java.util.concurrent.Callable;

public class iceCallable implements Callable<Integer> {

    private int money;

    public iceCallable(int money) {
        this.money = money;
    }

    @Override
    public Integer call() throws Exception {
        try {
            System.out.println("小弟开始去买雪糕");
            Thread.sleep(1000);
            System.out.println("小弟买完雪糕");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return money - 2;
    }
}
