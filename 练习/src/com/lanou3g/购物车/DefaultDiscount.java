package com.lanou3g.购物车;

public class DefaultDiscount implements Discountable {

    //不打折
    @Override
    public float discount(float totalMoney) {
        return totalMoney;

    }
}
