package com.lanou3g.hero;

public class Warrior extends Hero {
    public Warrior(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println("战士使用斧子劈砍");
    }


    @Override
    public void move() {
        System.out.println("骑着霜狼跑");
    }
}
