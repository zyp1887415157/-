package com.lanou3g.继承.hero;

public abstract class Hero {
    private String name;

    public Hero(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Hero setName(String name) {
        this.name = name;
        return this;
    }

     public abstract void attack();



     public abstract void move();

}
