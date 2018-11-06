package com.lanou3g.homework;

public class Family {


    private Man man;
    private Woman woman;
    private Child child;

    public Man getMan() {
        return man;
    }

    public Family setMan(Man man) {
        this.man = man;
        return this;
    }

    public Woman getWoman() {
        return woman;
    }

    public Family setWoman(Woman woman) {
        this.woman = woman;
        return this;
    }

    public Child getChild() {
        return child;
    }

    public Family setChild(Child child) {
        this.child = child;
        return this;
    }

    public  Family(Man man, Woman woman, Child child){
        this.man=man;
        this.woman=woman;
        this.child=child;

        man.setWife(woman);
        man.setSon(child);

        woman.setHusband(man);
        woman.setSon(child);

        child.setFather(man);
        child.setMother(woman);
    }

    public void play(){
        System.out.println(man.getName()+"和"+woman.getName()+"和"+child.getName()+"去旅游");
    }





}
