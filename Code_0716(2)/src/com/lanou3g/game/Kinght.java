package com.lanou3g.game;

public class Kinght extends Hero {

    public Kinght(){
        attackable = new KnifeAttack();
        moveable = new HorseMove();
    }
}
