package com.lanou.java.test1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDog {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Dog dog = (Dog) context.getBean("dog");
        System.out.println(dog);
    }
}
