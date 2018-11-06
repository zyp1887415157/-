package com.lanou3g;

public class Person {
    private   String  name;
    private   int   age;
    private   float  weight;

    public static void main(String[] args) {
        Person p = new Person("名字",25,25F);
        p.setName("张三");
        System.out.println(p.getName());
        System.out.println(p.getAge());
        System.out.println(p.getWeight());
    }

    public Person(){

    };

    public Person(String name, int age, float weight){
        this.name=name;
        this.age=age;
        this.weight=weight;
    };


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

    public float getWeight() {
        return weight;
    }

    public Person setWeight(float weight) {
        this.weight = weight;
        return this;
    }
}
