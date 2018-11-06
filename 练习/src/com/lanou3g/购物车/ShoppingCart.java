package com.lanou3g.购物车;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Goods> goodsList;

    public ShoppingCart() {
        goodsList = new ArrayList<>();
    }

    public void add(Goods goods){
        goodsList.add(goods);
    }

    //总价钱
    public float totalMoney(){
        float sum = 0;
        for (Goods goods : goodsList) {
            if (goods!=null){
                sum+=goods.getPrice();
            }
        }
        return sum;

    }
}
