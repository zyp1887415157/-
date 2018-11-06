package com.lanou3g.demo;

import java.util.Arrays;
import java.util.Random;

/**
 * @author liushuqing
 * Created by  18/7/9 上午10:48
 */
public class Main {
    public static void main(String[] args) {
        Calculatar calculatar = new Calculatar();
        //使用某个方法的时候,必须按照方法声明时的参数规则填写参数

        int a = 3, b = 5;
        //将某个方法的返回值赋值给一个变量
        int sum = calculatar.add(a, b);
        System.out.println("和为:" + sum);

        //在调用的时候传递的是什么参数,
        //那么在这次的调用中,形参的值就是什么
        int sum1 = calculatar.add(6, 10);
        System.out.println(sum1);

        int abs = calculatar.abs(9);
        int abs1 = calculatar.abs(-9);
        System.out.println(abs);
        System.out.println(abs1);

        Person person = new Person();
//        person.name = "齐天大圣";
//        person.age = 500;
        int age;
        person.setAge(-100);
        person.setName("齐天大圣");
        System.out.println(person.getAge());
        System.out.println(person.getName());
        person.eat(89,"提莫");


    }
}
