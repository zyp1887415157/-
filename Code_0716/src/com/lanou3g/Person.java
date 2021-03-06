package com.lanou3g;

public class Person {

    private Legs legs;
    private String name;


    public Person() {
        //在外部类创建内部类对象
        legs = new Legs();
    }

    public void walk() {
        legs.switchLeg();
    }

    public class Legs {
        /*
        内部类的使用场景
        当某个类的功能比较复杂,需要将其拆分为几部分,但是在类的外部 不需要知道几部分的细节,
        那么这个几部分 就可以声明为内部类
        内部类的特点:可以直接引用外部类的所有属性
        **内部类持有外部类的引用**
         */

        public void switchLeg() {
            System.out.println(Person.this.name + "腿在交换");
        }
    }

    public static class Inner {
        //静态内部类
        //当做是普通的类,外部类就相当于包
    }

}
