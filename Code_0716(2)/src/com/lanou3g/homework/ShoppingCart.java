package com.lanou3g.homework;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    //    private Goods[] goodsArr;
    private List<Goods> goodsList;
    private int index;

    public ShoppingCart() {
//        goodsArr = new Goods[5];
        goodsList = new ArrayList<>(5);
    }

    public void add(Goods goods) {
        goodsList.add(goods);
//        if (index >= goodsArr.length) {
//            Goods[] newArr = new Goods[goodsArr.length << 1];
//            for (int i = 0; i < goodsArr.length; i++) {
//                newArr[i] = goodsArr[i];
//            }
//            goodsArr = newArr;
//        }
//        goodsArr[index++] = goods;
    }

    public float totalMoney() {
        float sum = 0;
        for (Goods g : goodsList) {
            if (g != null) {
                sum += g.getPrice();
            }
        }
//        for (int i = 0; i < index; i++) {
//            sum += goodsArr[i].getPrice();
//        }
        return sum;
    }

//    public Goods[] getGoodsArr() {
//        return goodsArr;
//    }
}
