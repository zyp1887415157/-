package com.lanou3g.homework2;


public class Main {
    public static void main(String[] args) {
        Hero hero = new Mage();
        hero.setName("法师");
        ((Mage) hero).play();
        Hero hero1 = new Soldier();
        hero1.setName("战士");
        ((Soldier) hero1).play();


        System.out.println("-------玩家控制攻击移动-----");
        Player player = new Manito();
//        player.setName("大神");
//        player.setHero(soldier);
//        Manito m = (Manito) player;
//        m.attack();
//        m.move();

        Hero a = player.catchOne(2);
        if (a instanceof Mage) {
            player.setName("大神");
            player.setHero(hero);
            Manito m = (Manito) player;
            m.attack();
            m.move();
        } else if (a instanceof Soldier) {
            player.setName("大神");
            player.setHero(hero1);
            Manito m = (Manito) player;
            m.attack();
            m.move();
        }


//        player1.setName("菜鸟");
//        player1.setHero(mage);
//        Newbie n = (Newbie) player1;
//        n.attack();
//        n.move();

        Player player1 = new Newbie();
        Hero b = player.catchOne(2);
        if (b instanceof Mage) {
            player1.setName("菜鸟");
            player1.setHero(hero);
            Newbie n = (Newbie) player1;
            n.attack();
            n.move();
        } else if (b instanceof Soldier) {
            player1.setName("菜鸟");
            player1.setHero(hero1);
            Newbie n = (Newbie) player1;
            n.attack();
            n.move();
        }


    }
}
