package com.lanou3g.hero;

public class Mage extends Hero {

    public Mage(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.printf("法师: %s 释放法术攻击\n",getName());
    }

    @Override
    public void move() {
        System.out.printf("法师: %s 使用传送门移动\n",getName());
    }
}
