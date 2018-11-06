package com.lanou3g.homework2;


//玩家
public class Player {

    public static final int MAGE=1;
    public static final int SOLDIER=2;

    private String name;
    private Hero hero;

    public Hero getHero() {
        return hero;
    }

    public Player setHero(Hero hero) {
        this.hero = hero;
        return this;
    }

    public String getName() {
        return name;
    }


    public Player setName(String name) {
        this.name = name;
        return this;
    }

    public void attack() {
        System.out.println(getName() + "控制" + hero.getName() + "进行攻击");
    }

    public void move() {
        System.out.println(getName() + "控制" + hero.getName() + "进行移动");
    }

    public Hero catchOne(int type) {
        switch (type) {
            case 1:
                return new Mage();
            case 2:
                return new Soldier();

        }
        return null;
    }

}
