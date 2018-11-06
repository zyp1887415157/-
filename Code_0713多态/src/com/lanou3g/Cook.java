package com.lanou3g;

public abstract class Cook {


    //定义炒菜的流程,该流程 子类不能更改
    public final void cooking(){
        //1.开火
        fire();
        //2.倒油
        putOil();
        //3.放菜
        putVegetable();
        //4.放调料
        putFlavour();
        //5.翻炒
        fry();
    }

    protected void fire(){
        System.out.println("1.开火");
    }
    protected void putOil(){
        System.out.println("2.倒油");
    }
    protected abstract void putVegetable();

    protected abstract void putFlavour();

    protected void fry(){
        System.out.println("5.翻炒");
    }

}
