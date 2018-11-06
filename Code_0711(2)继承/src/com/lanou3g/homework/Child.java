package com.lanou3g.homework;

public class Child extends Person {
    private Man father;
    private Woman mother;


    public void dohomework(){
        System.out.println(mother.getName()+"和"+father.getName()+"辅导"+getName());
    }


    public Man getFather() {
        return father;
    }

    public Child setFather(Man father) {
        this.father = father;
        return this;
    }

    public Woman getMother() {
        return mother;
    }

    public Child setMother(Woman mother) {
        this.mother = mother;
        return this;
    }
}
