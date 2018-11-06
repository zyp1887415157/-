package com.lanou3g.购物车;


//实现折扣接口  打8折
public class EightDiscount implements Discountable {
    @Override
    public float discount(float totalMoney) {
        return totalMoney * 0.8F;
    }
}
