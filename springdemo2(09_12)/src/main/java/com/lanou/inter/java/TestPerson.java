package com.lanou.inter.java;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPerson {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");
        Person person = (Person) context.getBean("person");
        person.playWithAnimal();
    }
}
