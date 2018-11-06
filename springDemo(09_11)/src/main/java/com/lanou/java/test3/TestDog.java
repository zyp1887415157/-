package com.lanou.java.test3;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDog {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/applicationContext2.xml");
        Dog dog = (Dog) context.getBean("dog");
        dog.bark();
        System.out.println(dog);

    }
}
