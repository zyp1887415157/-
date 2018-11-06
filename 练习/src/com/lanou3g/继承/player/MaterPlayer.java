package com.lanou3g.继承.player;

public class MaterPlayer extends Player {

    public MaterPlayer(String name) {
        super(name);
    }

    @Override
    public void controlToAttack() {
        System.out.println("大神玩家:"+getName()+"控制");
        getHero().attack();
        getHero().attack();
        getHero().attack();
    }

    @Override
    public void controlToMove() {
        System.out.println("大神玩家:"+getName()+"控制");
        getHero().move();
    }
}
