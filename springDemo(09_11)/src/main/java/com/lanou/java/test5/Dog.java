package com.lanou.java.test5;

public class Dog {

    private String name;
    private  Integer age;

    public void  bark(){
        System.out.println("旺旺");
    }

    public void initDog(){
        System.out.println("init Dog");
    }
    public void destroyDog(){
        System.out.println("destroy Dog");
    }


    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("有参的构造方法");
    }

    public Dog() {
        System.out.println("无参构造方法");
    }

    public String getName() {
        System.out.println("get name");
        return name;
    }

    public void setName(String name) {
        System.out.println("set name");
        this.name = name;
    }

    public int getAge() {
        System.out.println("get age");
        return age;
    }

    public void setAge(int age) {
        System.out.println("set age");
        this.age = age;
    }
}
