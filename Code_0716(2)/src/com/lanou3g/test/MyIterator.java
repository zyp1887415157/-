package com.lanou3g.test;

import com.lanou3g.homework.Goods;

public interface MyIterator {

    //用来判断是否有下一个
    boolean hasNext();


    //获取下一个元素
    Goods next();
}
