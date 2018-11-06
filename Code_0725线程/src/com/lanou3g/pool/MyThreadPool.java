package com.lanou3g.pool;

public class MyThreadPool {

    //线程数组
    private SubThread[] threads;

    public MyThreadPool(int poolSize) {
        threads = new SubThread[poolSize];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new SubThread();
        }
    }

    //开启线程池
    public void start(){
        for (SubThread thread : threads) {
            thread.start();
        }
    }

    public void execute(Runnable r){
        SubThread.add(r);
    }
}
