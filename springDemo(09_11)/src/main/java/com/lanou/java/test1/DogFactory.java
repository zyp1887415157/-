package com.lanou.java.test1;

public class DogFactory {
    private static Dog dog;

    //普通工厂的方式
    public Dog getDog() {
        return new Dog();
    }

    //静态工厂的方式
     /*
     单例:单独的实例,static修饰对象
     单例的制作方式:懒汉式和饿汉式
     工厂:方法的返回值是某个类的对象
     普通工厂:每次调用都生成一个对象
     静态工厂:每次调用都是同一个对象
      */

    public static Dog getStaticDog(){
        if (dog==null){
            dog = new Dog();
        }
        return dog;
    }

    public String getPaper() {
        return null;
    }
}
