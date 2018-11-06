package com.lanou3g.entity;

public class Goods {

    private int id;
    private String name;
    private float price;
    private int count;
    private String unit;

    public Goods() {
    }

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", unit='" + unit + '\'' +
                '}'+"\n";
    }

    public Goods(int id, String name, float price, int count, String unit) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
        this.unit = unit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
