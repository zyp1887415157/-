package com.lanou3g.game;

public class Priest extends Hero {

    public Priest(){
        attackable = new MagicAttack();
        moveable = new HorseMove();
    }
}
