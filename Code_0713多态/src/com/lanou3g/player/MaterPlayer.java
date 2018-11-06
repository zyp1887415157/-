package com.lanou3g.player;

public class MaterPlayer extends Player {
    public MaterPlayer(String name) {
        super(name);
    }

    @Override
    public void controlToAttack() {
        System.out.printf("大神玩家: %s 控制\n",getName());
        getHero().attack();
        getHero().attack();
        getHero().attack();
    }

    @Override
    public void controlToMove() {
        System.out.printf("大神玩家: %s 控制\n",getName());
        getHero().move();
    }
}
