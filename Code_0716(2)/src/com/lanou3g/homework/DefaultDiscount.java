package com.lanou3g.homework;

/**
 * 不打折
 */
public class DefaultDiscount implements Discountable {

    @Override
    public float discount(float totalMoney) {
        return 0;
    }
}
