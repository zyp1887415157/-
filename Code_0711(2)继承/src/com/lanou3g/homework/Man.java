package com.lanou3g.homework;

public class Man extends Person {
    private Woman wife;
    private Child son;

    public void work(){
        System.out.println(getName()+"给"+wife.getName()+"和"+son.getName()+"挣钱");
    }


    public Woman getWife() {
        return wife;
    }

    public Man setWife(Woman wife) {
        this.wife = wife;
        return this;
    }

    public Child getSon() {
        return son;
    }

    public Man setSon(Child son) {
        this.son = son;
        return this;
    }
}
