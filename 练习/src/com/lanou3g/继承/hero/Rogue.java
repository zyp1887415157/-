package com.lanou3g.继承.hero;

public class Rogue extends Hero {

    public Rogue(String name) {
        super(name);
    }

    @Override
    public void move() {
        System.out.println("战士"+getName()+"正在移动");
    }

    @Override
    public void attack() {
        System.out.println("战士"+getName()+"使用物理攻击");
    }
}
