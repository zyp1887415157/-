package com.lanou3g.zoo;

public class Feeder {

    public static final int TYPE_P=1;
    public static final int TYPE_M=2;

//    public void feed(Penguin penguin){
//        penguin.eat();
//    }

    public void feed(Animal animal){
        animal.eat();
    }

    public Animal catchOne(int type){
        switch (type){
            case 1:
                //匿名对象
                return new Penguin("1企鹅",1);
            case 2:
                return new Mouse("1老鼠",2);
        }
        return null;
    }
}
