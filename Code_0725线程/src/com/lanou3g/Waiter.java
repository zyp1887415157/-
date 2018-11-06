package com.lanou3g;

public class Waiter extends Thread {

    public static final Object o = new Object();

    private int index;

    @Override
    public void run() {
        super.run();
        test();
    }

    private void test(){
        System.out.println(getName()+"子线程开始干一些事儿");
        System.out.println(getName()+"干了一半");
        synchronized (o){
            try {
                System.out.println(getName()+"子线程开始等待");
                o.wait();
                System.out.println(getName()+"子线程继续开始干");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void doSth(){
//        synchronized(this){
            index +=10;
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        }
    }

    public int getIndex() {
        return index;
    }
}
