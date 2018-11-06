package com.lanou3g.hero;

public class Shaman extends Hero {

    public Shaman(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println("萨满闪电箭");
    }

    @Override
    public void move() {
        System.out.println("萨满幽灵狼移动");
    }
}
