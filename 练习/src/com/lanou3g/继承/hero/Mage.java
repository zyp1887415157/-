package com.lanou3g.继承.hero;

public class Mage extends Hero {

    public Mage(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println("法师"+getName()+"释放法术攻击");
    }

    @Override
    public void move() {
        System.out.println("法师"+getName()+"使用传送们移动");
    }
}
