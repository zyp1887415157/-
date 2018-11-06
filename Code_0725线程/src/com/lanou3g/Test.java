package com.lanou3g;

import com.lanou3g.exe.ThreadPoolMain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {
    private static final List<Integer> data = new ArrayList<>();
    private static final Object o = new Object();

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                for (int i1 = 0; i1 < 100; i1++) {
                    synchronized (o) {
                        data.add(i1);
                    }
                }
            }).start();
        }
        try {
            Thread.sleep(1000);
            System.out.println(data.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ThreadPoolExecutor pool = new ThreadPoolExecutor(3,5,1,TimeUnit.SECONDS,new ArrayBlockingQueue<>(10));

        for (int i = 0; i < 15; i++) {
            pool.execute(new MyRun(i+1));

        }
        Thread.sleep(10000);

        for (int i = 0; i < 13; i++) {
            pool.execute(new MyRun(i+1));

        }

    }
    public static class MyRun implements Runnable{

        private int index;

        public MyRun(int index) {
            this.index = index;
        }

        @Override
        public void run() {
            System.out.println("线程编号为"+ index);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
