package com.lanou3g;

import com.lanou3g.hero.Hero;
import com.lanou3g.hero.Mage;
import com.lanou3g.hero.Rogue;
import com.lanou3g.hero.Warrior;
import com.lanou3g.player.MaterPlayer;
import com.lanou3g.player.Newbie;
import com.lanou3g.player.Player;
import com.lanou3g.robot.Robot;
import com.lanou3g.robot.WoodRobot;
import com.lanou3g.zoo.Animal;
import com.lanou3g.zoo.Sheep;

public class Main {
    public static void main(String[] args) {


        Hero h1 = new Rogue("李白");
        Hero h2 = new Warrior("宫本");
        Hero h3 = new Mage("诸葛亮");
        //匿名内部类对象
        //代表创建了一个没有名字的类,继承了Hero类,
        //并且重写了两个方法
        Hero h4 = new Hero("") {
            @Override
            public void attack() {
                System.out.println("匿名的方法");
            }

            @Override
            public void move() {


            }
        };
        h4.attack();

        Player p1 = new MaterPlayer("张三");
        Player p2 = new Newbie("李四");

        //具体的业务逻辑
        p1.select(h1);
        p1.controlToAttack();
        p1.controlToMove();


        p2.select(h3);
        p2.controlToAttack();
        p2.controlToMove();


        Robot robot = new WoodRobot();
        robot.create();


        Animal animal = new Sheep();
        animal.eat();
        animal.move();

        Cook cook = new PCook();
        cook.cooking();

        /*
        1.单例模式
        2.静态工厂 工厂模式   工厂方法
        3.模板方法
        4.建造者模式
         */
    }
}
