package com.lanou3g.homework;

public class EightDiscount implements Discountable {
    @Override
    public float discount(float totalMoney) {
        return totalMoney * 0.8F;
    }
}
