package com.lanou.java.test5;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDog {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/applicationContext3.xml");
        Dog dog = (Dog) context.getBean("dog");
        dog.setAge(3);
        System.out.println(dog);
        dog.bark();
//        context.close();
        Dog dog1 = (Dog) context.getBean("dog");
        System.out.println(dog1);
    }
}
