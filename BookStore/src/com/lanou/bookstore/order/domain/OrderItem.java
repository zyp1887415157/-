package com.lanou.bookstore.order.domain;

import com.lanou.bookstore.book.domain.Book;

public class OrderItem {
    private String iid;
    private  int count;//数量
    private double subtotal;//小计
    private Order order;//所属订单
    private Book book;//所有购买的书
    private String oid;
    private String bid;

    public String getBid() {
        return bid;
    }

    public OrderItem setBid(String bid) {
        this.bid = bid;
        return this;
    }

    public String getOid() {
        return oid;
    }

    public OrderItem setOid(String oid) {
        this.oid = oid;
        return this;
    }

    public String getIid() {
        return iid;
    }

    public OrderItem setIid(String iid) {
        this.iid = iid;
        return this;
    }

    public int getCount() {
        return count;
    }

    public OrderItem setCount(int count) {
        this.count = count;
        return this;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public OrderItem setSubtotal(double subtotal) {
        this.subtotal = subtotal;
        return this;
    }

    public Order getOrder() {
        return order;
    }

    public OrderItem setOrder(Order order) {
        this.order = order;
        return this;
    }

    public Book getBook() {
        return book;
    }

    public OrderItem setBook(Book book) {
        this.book = book;
        return this;
    }
}
