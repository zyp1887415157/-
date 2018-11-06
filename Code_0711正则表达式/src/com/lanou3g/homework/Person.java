package com.lanou3g.homework;

public class Person {
    private String name;
    private int age;
    private double height;

    public Person(){

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }

    public Person(String name, int age, double height){
        this.name=name;
        this.age=age;
        this.height=height;
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

    public double getHeight() {
        return height;
    }

    public Person setHeight(double height) {
        this.height = height;
        return this;
    }
}
