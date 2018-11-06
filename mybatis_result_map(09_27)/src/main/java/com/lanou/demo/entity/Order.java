package com.lanou.demo.entity;


import java.util.List;

public class Order {

  private int orderId;
  private int userId;
  private int goodsId;
  private int goodsQty;

  private User user;
  private Goods goods;

  @Override
  public String toString() {
    return "Order{" +
            "orderId=" + orderId +
            ", userId=" + userId +
            ", goodsId=" + goodsId +
            ", goodsQty=" + goodsQty +
            ", user=" + user +
            ", goods=" + goods +
            '}';
  }

  public int getOrderId() {
    return orderId;
  }

  public void setOrderId(int orderId) {
    this.orderId = orderId;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public int getGoodsId() {
    return goodsId;
  }

  public void setGoodsId(int goodsId) {
    this.goodsId = goodsId;
  }

  public int getGoodsQty() {
    return goodsQty;
  }

  public void setGoodsQty(int goodsQty) {
    this.goodsQty = goodsQty;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Goods getGoods() {
    return goods;
  }

  public void setGoods(Goods goods) {
    this.goods = goods;
  }
}
