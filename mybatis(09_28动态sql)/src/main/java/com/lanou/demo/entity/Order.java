package com.lanou.demo.entity;


import java.util.List;

public class Order {

  private int orderId;
  private String orderCode;
  private int userId;


  private User user;
  private List<OrderItem> orderItemList;

  @Override
  public String toString() {
    return "Order{" +
            "orderId=" + orderId +
            ", orderCode='" + orderCode + '\'' +
            ", userId=" + userId +
            ", user=" + user +
            ", orderItemList=" + orderItemList +
            '}';
  }

  public int getOrderId() {
    return orderId;
  }

  public void setOrderId(int orderId) {
    this.orderId = orderId;
  }

  public String getOrderCode() {
    return orderCode;
  }

  public void setOrderCode(String orderCode) {
    this.orderCode = orderCode;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }


  public List<OrderItem> getOrderItemList() {
    return orderItemList;
  }

  public void setOrderItemList(List<OrderItem> orderItemList) {
    this.orderItemList = orderItemList;
  }
}
