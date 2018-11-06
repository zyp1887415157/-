package com.lanou3g.test;

import com.lanou3g.homework.Goods;

import java.util.Iterator;

public class IteratorMain {
    public static void main(String[] args) {
        //迭代器模式
        //以一个统一的方式去遍历不同类型的容器

        Cart1 cart1 = new Cart1();
        Cart2 cart2 = new Cart2();

        //迭代器遍历第一个
        forEach(cart1);
        //迭代器遍历第二个
        forEach(cart2);

        for (Goods goods : cart1) {

        }


    }

    private static void forEach(Iterable<Goods> iterable) {
        Iterator<Goods> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Goods goods = iterator.next();

        }
    }

    //数组
    private static void forEachCart1(Cart1 cart1) {
        for (int i = 0; i < cart1.getGoodsArray().length; i++) {
            Goods g = cart1.getGoodsArray()[i];
        }
    }

    //集合
    private static void forEachCart2(Cart2 cart2) {
        for (int i = 0; i < cart2.getGoodsList().size(); i++) {
            Goods g = cart2.getGoodsList().get(i);
        }
    }
}
