package com.lanou3g.game;

public class Main {
    public static void main(String[] args) {

        Warrior warrior = new Warrior();
        warrior.setAttackable(new MagicAttack());
        warrior.setMoveable(new HorseMove());
        warrior.attack();
        warrior.move();
        System.out.println("-----------");
        Kinght k = new Kinght();
        k.attack();
        k.move();
        System.out.println("---------");
        Priest p = new Priest();
        p.attack();
        p.move();

    }
}
