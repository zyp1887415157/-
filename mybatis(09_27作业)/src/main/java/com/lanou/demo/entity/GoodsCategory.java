package com.lanou.demo.entity;


import java.io.Serializable;
import java.util.List;

public class GoodsCategory implements Serializable {

  private int categoryId;
  private String categoryName;

  private List<Goods> goodsList;

  @Override
  public String toString() {
    return "GoodsCategory{" +
            "categoryId=" + categoryId +
            ", categoryName='" + categoryName + '\'' +
            ", goodsList=" + goodsList +
            '}';
  }

  public int getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(int categoryId) {
    this.categoryId = categoryId;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  public List<Goods> getGoodsList() {
    return goodsList;
  }

  public void setGoodsList(List<Goods> goodsList) {
    this.goodsList = goodsList;
  }
}
