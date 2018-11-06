package com.lanou.demo.entity;


import java.util.List;

public class Goods {

  private int goodsId;
  private int categoryId;
  private String goodsName;
  private float goodsPrice;

  private GoodsCategory Category;
  private List<Order> orderList;

  @Override
  public String toString() {
    return "Goods{" +
            "goodsId=" + goodsId +
            ", categoryId=" + categoryId +
            ", goodsName='" + goodsName + '\'' +
            ", goodsPrice=" + goodsPrice +
            ", Category=" + Category +
            ", orderList=" + orderList +
            '}';
  }

  public int getGoodsId() {
    return goodsId;
  }

  public void setGoodsId(int goodsId) {
    this.goodsId = goodsId;
  }

  public int getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(int categoryId) {
    this.categoryId = categoryId;
  }

  public String getGoodsName() {
    return goodsName;
  }

  public void setGoodsName(String goodsName) {
    this.goodsName = goodsName;
  }

  public float getGoodsPrice() {
    return goodsPrice;
  }

  public void setGoodsPrice(float goodsPrice) {
    this.goodsPrice = goodsPrice;
  }

  public GoodsCategory getCategory() {
    return Category;
  }

  public void setCategory(GoodsCategory category) {
    Category = category;
  }

  public List<Order> getOrderList() {
    return orderList;
  }

  public void setOrderList(List<Order> orderList) {
    this.orderList = orderList;
  }
}
