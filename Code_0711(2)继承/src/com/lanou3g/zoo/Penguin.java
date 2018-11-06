package com.lanou3g.zoo;

public class Penguin extends Animal {


    /*
    原则:
   在创建一个对象的时候,调用构造方法时,
   一定会先调用父类的构造方法
     */


    public Penguin(String name, int id) {
        super(name, id);
    }

    /*
    方法的重写:
    在子类中把可以继承过来的方法重新声明一遍
    访问权限不能比父类的更严格
     */



    public void eat(){
        //调用父类的方法
//        super.eat();
        System.out.println(getName()+"XXXXXXXX吃");
    }

    public void catchFish(){
        System.out.println(getName()+"在捕鱼");
    }


}
