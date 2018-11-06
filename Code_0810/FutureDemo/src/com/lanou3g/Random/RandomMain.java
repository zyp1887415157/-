package com.lanou3g.Random;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.function.LongFunction;

public class RandomMain {
    public static void main(String[] args) throws Exception {
        /*
        生成50000000个随机数
        计算总耗时
         */
        long millis = System.currentTimeMillis();



        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        long sum = 0;
        for (int i = 0; i < 5; i++) {
            Future<?> submit = threadPool.submit(new Callable(millis));
            Long result = (Long) submit.get();
            sum = sum + result;
        }
        System.out.println(sum);
        threadPool.shutdown();


        Random r = new Random();
        for (int i1 = 0; i1 < 10000000; i1++) {
            r.nextInt();
        }
//        System.out.println(System.currentTimeMillis() - millis);
    }
}
