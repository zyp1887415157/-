package com.lanou3g;

import com.lanou3g.compare.MyComparable;

public class Person  {
    private String name;
    private int age;
    private float weight;
    private float height;


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", height=" + height +
                '}' + '\n';
    }

    public Person() {

    }

    public Person(String name, int age, float weight, float height) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public float getWeight() {
        return weight;
    }

    public float getHeight() {
        return height;
    }

//    @Override
//    public int compareTo(Person other) {
//        if (this.age < other.age) {
//            return -1;
//        } else if (this.age > other.age) {
//            return 1;
//        }
//        return 0;
//    }
}
