package com.lanou3g;

public class Dog {

    private String name;
    private int age;
    private float weight;


    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}'+'\n';
    }

    public Dog() {

    }

    public Dog(String name, int age, float weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public float getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }
}
