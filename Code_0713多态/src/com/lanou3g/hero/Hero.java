package com.lanou3g.hero;

public abstract class Hero {

    /*
    1.如果一个类中有抽象方法,那么该类一定是抽象类(没有方法体);
    2.抽象类的作用:规定了父类知到有某个方法,但是不知道具体怎么执行;
    3.如果一个类(普通类)继承了抽象类,那么必须重写抽象类的所有抽象方法;

     */
    private String name;

    public Hero(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Hero setName(String name) {
        this.name = name;
        return this;
    }


    public abstract void  attack();

    public  abstract void  move();

}
