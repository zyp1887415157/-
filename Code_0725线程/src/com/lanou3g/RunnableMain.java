package com.lanou3g;

public class RunnableMain {
    public static void main(String[] args) {
        //第二种开启线程的方式,实现Runnable接口
        for (int i = 0; i < 5; i++) {
            MyRunnable myRunnable = new MyRunnable();
            Thread t = new Thread(myRunnable, "线程" + i);
            t.start();
        }

        // 简写1
        Thread t1 = new Thread(new MyRunnable());
        t1.start();

        //简写2
        new Thread(new MyRunnable()).start();

        //随便开个线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();
        //lambda
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }).start();
    }
}
