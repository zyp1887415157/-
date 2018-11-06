package com.lanou.demo.entity;

import java.util.List;

public class UserMoney extends User {

    private int id;
    private String name;
    private float money;

    private List<Order> orderList;

    @Override
    public String toString() {
        return "UserMoney{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                ", orderList=" + orderList +
                '}';
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    @Override
    public List<Order> getOrderList() {
        return orderList;
    }

    @Override
    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
