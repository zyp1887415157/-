package com.lanou.demo;


import com.lanou.demo.bean.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:spring-web.xml");
        Person person = (Person) context.getBean("person");
        System.out.println(person);
    }
}
