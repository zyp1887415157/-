package com.lanou3g.observer;

import java.util.ArrayList;
import java.util.List;

//龙哥
public class DragonMan implements Subject {

    private List<Observer> observers = new ArrayList<>();

    //龙哥下命令
    public void order(){
        String msg = "给我上,干他娘的!!";
        System.out.println(msg);
        notifyObserver(msg);
    }

    @Override
    public void add(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver(String message) {
        for (int i = 0; i < observers.size(); i++) {
           Observer o = observers.get(i);
           o.handleMessage(this,message);
           if (!observers.contains(o)){
               i--;
           }
        }
    }
}
