package com.lanou3g;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class SyncDemo {
    private static List<Integer> data = new ArrayList<>();

    private static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {

        //1.把线程不安全的集合转换为线程安全的
//         data = Collections.synchronizedList(SyncDemo.data);

//        Hashtable  线程安全的Map

        //2.直接使用线程安全的集合对象
//         data = new Vector<>();    线程安全的集合

        //3.使用同步代码块
        // 每次只能有一个线程访问该代码


        /*
        开启5条线程
        每条线程都向集合中放入100个数
        总计500个
         */
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                for (int i1 = 0; i1 < 100; i1++) {
                    // 保证同时只能有一个线程访问该代码
                    synchronized (lock) {
                        data.add(i1);
                    }
                }
            }).start();
        }
        //为了保证5条线程都能执行完
        Thread.sleep(1000);
        System.out.println(SyncDemo.data.size());
        /*
        1.程序正常执行 ,输出结果500
        2.程序正常执行,输出结果小于500
        3.抛出下标越界异常
         */


        Waiter waiter = new Waiter();

        //同步的成员方法的锁是当前类的对象
        //同步的静态方法的锁是当前的类

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                for (int i1 = 0; i1 < 10; i1++) {
                    waiter.doSth();
                }
            }).start();
        }
        Thread.sleep(1000);
        System.out.println(waiter.getIndex());



    }
}
