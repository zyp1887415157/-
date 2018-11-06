package com.lanou3g.购物车;
//收银台
public class CashierDesk {

    private ShoppingCart shoppingCart;
    private Discountable discountable;

    public CashierDesk(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
        discountable = new DefaultDiscount();
    }

    public float checkout(){
        float totalMoney = shoppingCart.totalMoney();

        //返回折扣完的总钱数
        return discountable.discount(totalMoney);
    }

    //设置打折
    public CashierDesk setDiscountable(Discountable discountable) {
        this.discountable = discountable;
        return this;
    }
}
