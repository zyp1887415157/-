package com.lanou3g.购物车;

public class Goods {

    private int id;
    private String name;
    private float price;

    public Goods(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }
}
