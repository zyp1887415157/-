package com.lanou3g.observer;
//主题用来发布消息
public interface Subject {

    void add(Observer observer);

    void remove(Observer observer);

    void notifyObserver(String message);
}
