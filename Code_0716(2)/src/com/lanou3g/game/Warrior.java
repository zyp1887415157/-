package com.lanou3g.game;

public class Warrior extends Hero {

    public Warrior() {
        // 为攻击/移动两个接口赋值
        attackable = new KnifeAttack();
        moveable = new NormalMove();
    }
}
