package com.lanou3g.购物车;

public class SevenDiscount implements Discountable {
    @Override
    public float discount(float totalMoney) {
        return totalMoney * 0.7f;
    }
}
