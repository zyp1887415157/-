package com.lanou3g;

public class Goods {

    private String name;
    private float price;

    public Goods() {

    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public Goods(String name, float price, int id) {
        this.name = name;
        this.price = price;

    }

    public Goods setName(String name) {
        this.name = name;
        return this;
    }

    public Goods setPrice(float price) {
        this.price = price;
        return this;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }


}
