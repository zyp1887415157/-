package com.lanou.java.Test2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext1.xml");
        Person person = (Person) context.getBean("person");
        person.playwith();
    }
}
