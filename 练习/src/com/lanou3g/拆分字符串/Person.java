package com.lanou3g.拆分字符串;

public class Person {
    private  String name;
    private int age;
    private float height;


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Person setAge(int age) {
        this.age = age;
        return this;
    }

    public float getHeight() {
        return height;
    }

    public Person setHeight(float height) {
        this.height = height;
        return this;
    }
}
