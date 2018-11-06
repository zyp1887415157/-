package com.lanou3g;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Main {
    public static void main(String[] args) throws Exception {
        // java中线程开启有几种方式
        /*
        如果回答1种:
        核心的就是调用Thread对象的start方法;
        两种:
        一种是继承Thread,
        一种是实现Runnable 接口,也带利用Thread的类才能开启

        多种:
        上面两种 +
        线程池也能开启线程,
        FutureTask(也是实现Runnable 接口)
         */


        JoinRunnable runnable = new JoinRunnable();
        Thread thread = new Thread(runnable);
        System.out.println("大哥通知小弟买雪糕");
        thread.start();
        thread.join();
        System.out.println("大哥开始吃雪糕");


        FutureTask<Integer> task = new FutureTask<>(new iceCallable(10));
        System.out.println("二弟拿着10块钱去买雪糕");
        Thread thread1 = new Thread(task);
        thread1.start();

        Integer i = task.get();
        System.out.println(i);

        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        Future<?> future = threadPool.submit(new iceCallable(10));
        Object result = future.get();
        //获取子线程运行之后的结果
        System.out.println(result);






    }
}
