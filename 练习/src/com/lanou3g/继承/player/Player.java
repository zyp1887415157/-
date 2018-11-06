package com.lanou3g.继承.player;

import com.lanou3g.继承.hero.Hero;

public abstract class Player {
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

    public abstract void controlToAttack();



    public abstract void controlToMove();


    public void select(Hero hero) {
        this.hero = hero;
    }
}
