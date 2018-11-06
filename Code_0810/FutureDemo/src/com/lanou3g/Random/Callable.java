package com.lanou3g.Random;

import java.util.Random;

public class Callable implements java.util.concurrent.Callable<Long> {

//
    private long millis;

    //作用
    //可以保证在某个线程中都使用独立的某个对象
    private ThreadLocal<Random> local = new ThreadLocal<Random>(){
        @Override
        protected Random initialValue() {
            return new Random();
        }
    };

    public Callable(long millis) {
        this.millis = millis;
    }


    @Override
    public Long call() throws Exception {
        Random r = new Random();
        for (int i1 = 0; i1 < 10000000; i1++) {
            r.nextInt();
        }
        long time = System.currentTimeMillis() - millis;
        return time;
    }
}
