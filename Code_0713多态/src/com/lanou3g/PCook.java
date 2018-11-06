package com.lanou3g;

public class PCook extends Cook {
    @Override
    protected void putVegetable() {
        System.out.println("3.放土豆丝");
    }

    @Override
    protected void putFlavour() {
        System.out.println("4.放盐");
    }
}
