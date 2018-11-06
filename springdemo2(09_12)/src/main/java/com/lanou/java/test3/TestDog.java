package com.lanou.java.test3;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDog {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext5.xml");
        Dog dog = (Dog) context.getBean("dog");
//        Person person = (Person) context.getBean("person");
        System.out.println(dog);
    }
}
