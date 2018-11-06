package com.lanou3g.zoo;

public class Mouse extends Animal {

    public Mouse(String name, int id) {
        super(name, id);
    }

    public void eat(){
        System.out.println(getName()+"正在吃大米");
    }

    public void stealOil(){
        // 使用从父类继承来的属性
        System.out.println(getName()+"正在偷油");
    }

}
