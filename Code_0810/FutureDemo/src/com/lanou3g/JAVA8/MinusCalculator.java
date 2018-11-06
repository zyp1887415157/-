package com.lanou3g.JAVA8;
//函数是接口
//1.接口中只有一个抽象方法
//2.或者有一些Object类的方法
//3.或者有一些default方法

//结论:接口中只能存在一个必须实现的抽象方法


//这个注释  用来检测某个接口是不是函数式接口
@FunctionalInterface
public interface MinusCalculator {

    int minus(int x, int y);


    int hashCode();


    boolean equals(Object obj);

    default void fun() {
        System.out.println("我是计算减法的接口");
    }
}
