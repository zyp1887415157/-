package com.lanou3g.homework;

public class Woman extends Person {
    private Man husband;
    private Child son;


    public void cook(){
        System.out.println(getName()+"给"+husband.getName()+"和"+son.getName()+"做饭");
    }


    public Man getHusband() {
        return husband;
    }

    public Woman setHusband(Man husband) {
        this.husband = husband;
        return this;
    }

    public Child getSon() {
        return son;
    }

    public Woman setSon(Child son) {
        this.son = son;
        return this;
    }
}
