package com.lanou.java.test2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testPaper {
    public static void main(String[] args) {

//        普通方法
//        PaperFactory factory1 = new PaperFactory();
//        Paper paper = factory1.getPaper();
//        paper.testpp();
//
//        Paper paper2 = PaperFactory.getStaticPaper();
//        paper2.testpp();

//        使用框架
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
        Paper paper1 = (Paper) context.getBean("paper1");
        Paper paper2 = (Paper) context.getBean("paper2");
        Paper paper3 = (Paper) context.getBean("paper3");
        paper1.testpp();
        paper2.testpp();
        paper3.testpp();
    }
}
