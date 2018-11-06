package com.lanou.demo.entity;

public class OrderItem {
    private int itemId;
    private int orderId;
    private int goodsId;
    private int goodsQty;


    private Order order;
    private Goods goods;

    @Override
    public String toString() {
        return "OrderItem{" +
                "itemId=" + itemId +
                ", orderId=" + orderId +
                ", goodsId=" + goodsId +
                ", goodsQty=" + goodsQty +
                ", order=" + order +
                ", goods=" + goods +
                '}';
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
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


    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}
