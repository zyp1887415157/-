package com.lanou3g.hero;

public class Rogue extends Hero {
    public Rogue(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.printf("战士: %s 释放物理攻击\n",getName());
    }

    @Override
    public void move() {
        System.out.printf("战士: %s 使用传送门移动\n",getName());
    }
}
