package com.lanou3g;

public class WaiterDemo {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            new Waiter().start();
        }

        Thread.sleep(3000);
        System.out.println("主线程开始通知");
        synchronized (Waiter.o){
            Waiter.o.notifyAll();
        }
    }
}
