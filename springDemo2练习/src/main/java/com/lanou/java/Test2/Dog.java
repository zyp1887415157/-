package com.lanou.java.Test2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Dog implements Animal {
    @Value("蛋黄")
    private String name;

    @Override
    public void show() {
        System.out.println(this.name+"再叫");
    }
}
