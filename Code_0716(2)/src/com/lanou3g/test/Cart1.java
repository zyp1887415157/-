package com.lanou3g.test;

import com.lanou3g.homework.Goods;

import java.util.Iterator;

public class Cart1 implements Iterable<Goods> {

    private Goods[] goodsArray = new Goods[10];



    public Goods[] getGoodsArray() {
        return goodsArray;
    }

    @Override
    public Iterator<Goods> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Goods> {
        private int index;

        @Override
        public boolean hasNext() {
            return index < goodsArray.length;
        }

        @Override
        public Goods next() {
            return goodsArray[index++];
        }
    }

}
