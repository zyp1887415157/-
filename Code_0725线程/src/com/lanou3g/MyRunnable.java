package com.lanou3g;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        //获取当前的线程对象
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());
    }
}
