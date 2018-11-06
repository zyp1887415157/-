package com.lanou3g.JAVA8;

public class Calculator implements AddCalculator, MinusCalculator {


    boolean flag;

    @Override
    public void fun() {
//        if (flag) {
            AddCalculator.super.fun();
//        } else {
            MinusCalculator.super.fun();
//        }
//        flag = !flag;

    }

    @Override
    public int add(int x, int y) {
        return x + y;
    }

    @Override
    public int minus(int x, int y) {
        return x - y;
    }
}
