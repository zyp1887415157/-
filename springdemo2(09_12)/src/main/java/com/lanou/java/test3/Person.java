package com.lanou.java.test3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
//使用该类实例化  Person person = new  Person;
//Component("id值") ,如果() 中不写,默认值是该类首字母小写
@Component("person")  //当所属的bean不在以下三层,或不明确的时候使用
public class Person {
//    <property name = "name" value="刘德华">
    @Value(value = "刘德华")
    String name;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

}
