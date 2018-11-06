package com.lanou3g.player;

public class Newbie extends Player {
    public Newbie(String name) {
        super(name);
    }

    @Override
    public void controlToAttack() {
        System.out.printf("菜鸟玩家: %s 控制\n",getName());
        getHero().attack();
    }

    @Override
    public void controlToMove() {
        System.out.printf("菜鸟玩家: %s 控制\n",getName());
        getHero().move();
    }
}
