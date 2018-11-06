package com.lanou3g.homework2;
//菜鸟
public class Newbie extends Player {


    private Hero hero;

    @Override
    public Hero getHero() {
        return hero;
    }

    @Override
    public Newbie setHero(Hero hero) {
        this.hero = hero;
        return this;
    }

    public void attack(){
        System.out.println(getName() + "控制" + hero.getName() + "进行一次攻击");

    }

    public void move(){
        System.out.println(getName() + "控制" + hero.getName() + "进行移动");
    }
}
