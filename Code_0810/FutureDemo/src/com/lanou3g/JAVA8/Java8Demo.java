  package com.lanou3g.JAVA8;

import java.util.Arrays;

public class Java8Demo {
    public static void main(String[] args) {
        int[] array = {8, 2, 1, 5, 2, 3, 9, 6, 4};

//        把数组转成 stream
        double v = Arrays.stream(array)
                .parallel()//把流转成并发流
                .filter(n -> n % 2 == 1)
                .average()  //算平均值
                .getAsDouble();
        System.out.println(v);
//                .sorted()
//                .forEach(System.out::println);



        AddCalculator calculator = (x, y) -> x + y;
        int add = calculator.add(10, 20);
        System.out.println(add);

        Calculator c = new Calculator();
        int add1 = c.add(30, 50);
        System.out.println(add1);
        c.fun();

        PPP:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i + j == 15) {
                    break PPP;
                }
            }
        }


        //对数组进行并发排序
        Arrays.parallelSort(array);
        System.out.println(Arrays.toString(array));
    }
}
