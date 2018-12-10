package com.lanou.bookstore.order.domain;

import java.util.List;

public class Order {
    private String oid;
    private String ordertime;//下单时间
    private Double total;//合计
    private Integer state;//订单状态
    private String address;//收货地址
    private List<OrderItem> orderItemList;//当前订单下所有条目
    private String uid;

    public String getOid() {
        return oid;
    }

    public Order setOid(String oid) {
        this.oid = oid;
        return this;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public Order setOrdertime(String ordertime) {
        this.ordertime = ordertime;
        return this;
    }

    public Double getTotal() {
        return total;
    }

    public Order setTotal(Double total) {
        this.total = total;
        return this;
    }

    public Integer getState() {
        return state;
    }

    public Order setState(Integer state) {
        this.state = state;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Order setAddress(String address) {
        this.address = address;
        return this;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public Order setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
        return this;
    }

    public String getUid() {
        return uid;
    }

    public Order setUid(String uid) {
        this.uid = uid;
        return this;
    }
}
