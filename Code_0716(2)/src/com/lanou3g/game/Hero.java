package com.lanou3g.game;

public class Hero {

    /*
    要求:
    战士 : 用刀砍  走路
    法师 : 用魔法攻击  闪现走路
    骑士 : 用刀砍   骑马走路
    牧师 : 用魔法攻击  骑马走路
     */

    protected Attackable attackable;
    protected Moveable moveable;


    public void attack() {
        attackable.attack();
    }



    public void move() {
        moveable.move();
    }

    public Hero setAttackable(Attackable attackable) {
        this.attackable = attackable;
        return this;
    }

    public Hero setMoveable(Moveable moveable) {
        this.moveable = moveable;
        return this;
    }
}
