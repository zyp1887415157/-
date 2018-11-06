package com.lanou3g.继承.player;

public class Newbie extends Player {
    public Newbie(String name) {
        super(name);
    }

    @Override
    public void controlToAttack() {
        System.out.println("菜鸟:"+getName()+"控制");
        getHero().attack();
    }

    @Override
    public void controlToMove() {
        System.out.println("菜鸟:"+getName()+"控制");
        getHero().move();
    }
}
