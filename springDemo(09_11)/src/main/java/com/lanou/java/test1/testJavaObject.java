package com.lanou.java.test1;

public class testJavaObject {
    public static void main(String[] args) {
        Dog dog = new Dog();

        //普通工厂
        DogFactory factory = new DogFactory();
        Dog dog2 = factory.getDog();

        //静态工厂
        Dog dog3 = DogFactory.getStaticDog();
    }
}
