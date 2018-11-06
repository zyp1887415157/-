package com.lanou3g.robot;

public class WoodRobot extends Robot {
    @Override
    protected void createHead() {
        System.out.println("用桌子腿组成脑袋");
    }

    @Override
    protected void createBody() {
        System.out.println("用桌面组成身体");
    }

    @Override
    protected void createArm() {
        System.out.println("组装个胳膊");
    }

    @Override
    protected void createLeg() {
        System.out.println("腿");
    }
}
