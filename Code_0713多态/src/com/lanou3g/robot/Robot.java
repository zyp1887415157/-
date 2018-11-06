package com.lanou3g.robot;

public abstract class Robot {
    //机器人组装方法  模板方法模式 先定义大体流程,在由子类具体实现
    public final void create() {
        System.out.println("组装脑袋");
        createHead();
        System.out.println("组装身体");
        createBody();
        System.out.println("组装胳膊");
        createArm();
        System.out.println("组装大腿");
        createLeg();
    }

    protected abstract void createHead();

    protected abstract void createBody();

    protected abstract void createArm();

    protected abstract void createLeg();
}
