package com.lanou3g;

public class Main {
    public static void main(String[] args) {

        //在java中线程的类就是Thread
       //新建5个线程,观察执行过程
        System.out.println("开始创建线程对象");
        MyThread m1 = new MyThread("Thread-1");
        MyThread m2 = new MyThread("Thread-2");
        MyThread m3 = new MyThread("Thread-3");
        MyThread m4 = new MyThread("Thread-4");
        MyThread m5 = new MyThread("Thread-5");
        System.out.println("同时开启多个线程");
        //调用线程对象的start()放法即可开启方法
        m1.start();
        m2.start();
        m3.start();
        m4.start();
        m5.start();
        System.out.println("多线程开启完毕");
        new MyThread("aa").start();
    }
}
