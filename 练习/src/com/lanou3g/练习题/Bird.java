package com.lanou3g.练习题;
//鸟
public class Bird {
    public int leg = 2;
    public int flychi = 2;
    private String name;

    public int getLeg() {
        return leg;
    }

    public Bird setLeg(int leg) {
        this.leg = leg;
        return this;
    }

    public int getFlychi() {
        return flychi;
    }

    public Bird setFlychi(int flychi) {
        this.flychi = flychi;
        return this;
    }

    public String getName() {
        return name;
    }

    public Bird setName(String name) {
        this.name = name;
        return this;
    }

    public void haveWing(){
       System.out.println("翅膀");
   }

   public void leg(){
       System.out.println("两条腿");
   }
}
