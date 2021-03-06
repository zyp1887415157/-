package com.lanou3g.homework;

public class Goods implements Comparable<Goods> {


    private int id;
    private String name;
    private float price;

    public int getId() {
        return id;
    }

    public Goods(int id ,String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    //用来自定义比较规则
    @Override
    public int compareTo(Goods o) {
//        return this.price - o.price;
        float f = price - o.price;
        if (f < 0) return -1;
        if (f > 0) return 1;
        return 0;
    }
}
