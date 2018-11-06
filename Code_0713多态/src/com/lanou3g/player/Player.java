package com.lanou3g.player;

import com.lanou3g.hero.Hero;

public class Player {

    private String name;
    private Hero hero;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Player setName(String name) {
        this.name = name;
        return this;
    }

    public Hero getHero() {
        return hero;
    }

    public Player setHero(Hero hero) {
        this.hero = hero;
        return this;
    }

    public void controlToAttack() {
        System.out.print(name+"控制");
        hero.attack();
    }

    public void controlToMove() {
        System.out.print(name+"控制");
        hero.move();
    }

    public void select(Hero hero) {
        this.hero = hero;
    }
}
