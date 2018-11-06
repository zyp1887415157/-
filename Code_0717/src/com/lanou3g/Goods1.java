package com.lanou3g;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Goods1 implements Iterable<Goods1> {

    private String name;
    private float price;
    private Goods1[] goodsArray = new Goods1[10];


    public Goods1[] getGoods1s(){
        return goodsArray;
    }

    @Override
    public Iterator<Goods1> iterator() {
        return new ArrayIterator();
    }



    private class ArrayIterator implements Iterator<Goods1>{
        private int index;

        @Override
        public boolean hasNext() {
            return index<goodsArray.length;
        }

        @Override
        public Goods1 next() {
            return goodsArray[index++];
        }
    }

    public class ArrayIteratorImpl extends ArrayIterator { }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public Goods1 setName(String name) {
        this.name = name;
        return this;
    }

    public Goods1 setPrice(float price) {
        this.price = price;
        return this;
    }
}
