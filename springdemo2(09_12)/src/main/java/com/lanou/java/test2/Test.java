package com.lanou.java.test2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
        ClassRoom classRoom = (ClassRoom) context.getBean("classRoom");
        System.out.println(classRoom);
    }
}
