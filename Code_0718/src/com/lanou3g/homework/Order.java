package com.lanou3g.homework;

import java.util.List;

public class Order {
    private String name;
    private List<ShoppingCart> shoppingCarts;

    public String getName() {
        return name;
    }

    public Order setName(String name) {
        this.name = name;
        return this;
    }

    public List<ShoppingCart> getShoppingCarts() {
        return shoppingCarts;
    }

    public Order setShoppingCarts(List<ShoppingCart> shoppingCarts) {
        this.shoppingCarts = shoppingCarts;
        return this;
    }
}
