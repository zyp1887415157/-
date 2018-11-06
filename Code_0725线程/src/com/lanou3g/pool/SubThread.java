package com.lanou3g.pool;

import java.util.concurrent.LinkedBlockingQueue;

//子线程
public class SubThread extends Thread {

    //阻塞队列
  private static final LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();

    @Override
    public void run() {
        try {
            while (true) {
                Runnable r = queue.take();
                r.run();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void add(Runnable r){
        queue.add(r);
    }
}
