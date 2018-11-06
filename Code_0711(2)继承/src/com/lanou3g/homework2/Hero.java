package com.lanou3g.homework2;
//英雄
public class Hero {
    private String name;


    public String getName() {
        return name;
    }

    public Hero setName(String name) {
        this.name = name;
        return this;
    }



    public void attack(){
        System.out.println(name+"正在攻击");
    }

    public void move(){
        System.out.println(name+"正在移动");
    }
}
