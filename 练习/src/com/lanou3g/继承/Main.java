package com.lanou3g.继承;

import com.lanou3g.继承.hero.Hero;
import com.lanou3g.继承.hero.Mage;
import com.lanou3g.继承.hero.Rogue;
import com.lanou3g.继承.player.MaterPlayer;
import com.lanou3g.继承.player.Newbie;
import com.lanou3g.继承.player.Player;
import com.sun.media.jfxmedia.events.PlayerEvent;

public class Main {
    public static void main(String[] args) {
        Hero h1 = new Rogue("李白");
        Hero h2 = new Mage("诸葛亮");

        Player p1 = new MaterPlayer("张三");
        Player p2 = new Newbie("李四");


        p1.select(h1);
        p1.controlToAttack();
        p1.controlToMove();

        p2.select(h2);
        p2.controlToAttack();
        p2.controlToMove();
    }


}
