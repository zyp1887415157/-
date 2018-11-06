package com.lanou3g.zoo;

public class Cat extends Animal {

    public Cat(String name, int id) {
        super(name, id);
    }

    public void eat(){
        System.out.println(getName()+"在吃鱼");
    }
    public void play(){
        System.out.println(getName()+"在玩逗猫棒");
    }
}
