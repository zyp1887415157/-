package com.lanou.java.test4;

import com.lanou.java.test3.Dog;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/applicationContext2.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student);

    }
}
