package com.lanou3g;

import com.lanou3g.butten.Butten;
import com.lanou3g.observer.*;

public class Main {
    public static void main(String[] args) {
        DragonMan dragonMan = new DragonMan();
        BMW bmw = new BMW();
        Servant servant = new Servant();
        Knife knife = new Knife();
        People people = new People();

        dragonMan.add(bmw);
        dragonMan.add(servant);
        dragonMan.add(knife);
        dragonMan.add(people);
        dragonMan.order();
        System.out.println("------");
        dragonMan.order();
        System.out.println("------");

        Butten butten = new Butten();
        butten.setOnClickListener(new Butten.OnClickListener() {
            @Override
            public void onClick(Butten btn) {
                System.out.println("自定义的单击事件");
            }
        });
        butten.performClick();


    }
}
