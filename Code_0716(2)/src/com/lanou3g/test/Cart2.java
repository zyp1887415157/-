package com.lanou3g.test;

import com.lanou3g.homework.Goods;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cart2 implements Iterable<Goods> {

    private List<Goods> goodsList = new ArrayList<>();

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    @Override
    public Iterator<Goods> iterator() {
        return new ListIterator();
    }


    private class ListIterator implements Iterator<Goods>{

        private int index;
        @Override
        public boolean hasNext() {
            return index<goodsList.size();
        }

        @Override
        public Goods next() {
            return goodsList.get(index++);
        }
    }
}
