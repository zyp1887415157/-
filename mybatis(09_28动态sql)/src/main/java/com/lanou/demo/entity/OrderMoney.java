package com.lanou.demo.entity;

public class OrderMoney extends Order {

    //    private int orderId;
//    private String orderCode;
//    private int userId;
    private float money;


//    private User user;
//    private List<OrderItem> orderItemList;


    @Override
    public String toString() {
        return "OrderMoney{" +
                "money=" + money +
                "} " + super.toString();
    }


    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }


}
