package com.lanou3g.购物车;

public class Main {
    public static void main(String[] args) {
        Goods g1 = new Goods(2, "商品1", 10);
        Goods g2 = new Goods(4, "商品2", 20);
        Goods g3 = new Goods(1, "商品3", 30);
        Goods g4 = new Goods(8, "商品4", 40);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(g1);
        shoppingCart.add(g2);
        shoppingCart.add(g3);
        shoppingCart.add(g4);

        CashierDesk cashierDesk = new CashierDesk(shoppingCart);
//        cashierDesk.setDiscountable(new EightDiscount());
        cashierDesk.setDiscountable(new SevenDiscount());
        System.out.println(cashierDesk.checkout());
    }
}


