package com.lanou.java.test1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDog {
    public static void main(String[] args) {
//        Dog dog = new Dog();
//        dog.bark();
//        在学习框架之前, 使用JAVAEE技术,java代码实例化对象
//        spring框架,通过配置文件实例化对象

//        打开容器(两种方式1.beanFactory 2.ApplicationContext),调用接口
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
//        getBean(),参数是在配置文件里面设置的id,String类型
//        返回值是Object类型,想要获得任意类型,需要强转
        Dog dog = (Dog) context.getBean("dog");
        dog.bark();
    }
}
