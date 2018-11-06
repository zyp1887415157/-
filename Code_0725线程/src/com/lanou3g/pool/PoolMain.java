package com.lanou3g.pool;

import java.util.concurrent.LinkedBlockingQueue;

public class PoolMain {
    //队列 先进先出
    //栈 后进先出
    public static void main(String[] args) throws InterruptedException {

        //线程池
        //阻塞队列
        LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
        //实现一个简单的线程池

//        SubThread t1 = new SubThread();
//        t1.start();
//        SubThread t2 = new SubThread();
//        t2.start();
//        SubThread t3 = new SubThread();
//        t3.start();
//        for (int i = 0; i < 50; i++) {
//            final int index = i;
//            SubThread.add(new Runnable() {
//                @Override
//                public void run() {
//                    Thread thread = Thread.currentThread();
//                    System.out.println(thread.getName() + "任务" + index);
//                    try {
//                        Thread.sleep(1500);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//        }


//        queue.add(()->{});
//        queue.add(()->{});
//        queue.add(()->{});
//
//        //会先取到第一个,依次取
//        Runnable take1 = queue.take();
//        Runnable take2 = queue.take();
//        Runnable take3 = queue.take();
//
//        //会阻塞  没有可取的值等待有值可取再走
//        Runnable take4 = queue.take();

        MyThreadPool pool = new MyThreadPool(3);
        pool.start();

        for (int i = 0; i < 50; i++) {
            final int index = i;
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("任务"+index);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

}
