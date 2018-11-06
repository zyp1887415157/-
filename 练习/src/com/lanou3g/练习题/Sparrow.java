package com.lanou3g.练习题;
//麻雀
public class Sparrow extends Bird{
    private int age;
    private float wight;


    public void weight(){
        System.out.println("我的体重是"+wight);
    }

    public void age(){
        System.out.println("我的年龄是"+age);
    }

    public void name(){
        System.out.println("我的名字是"+getName());
    }


    public int getAge() {
        return age;
    }

    public Sparrow setAge(int age) {
        this.age = age;
        return this;
    }

    public float getWight() {
        return wight;
    }

    public Sparrow setWight(float wight) {
        this.wight = wight;
        return this;
    }
}
