package com.lanou3g.homework;

import java.util.List;

public class ShoppingCart{
    private String name;
    private List<Goods> goodsList;

    public String getName() {
        return name;
    }

    public ShoppingCart setName(String name) {
        this.name = name;
        return this;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public ShoppingCart setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
        return this;
    }
}
