package com.lanou3g.homework;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Album> albums = getAlbums();
        //写到文件里面
        FileWriter writer = null;
        try {
            writer = new FileWriter("Test.txt");
            for (Album album : albums) {
                String name = album.getName();
                writer.write("\n专辑名称:"+name+"\n");
                System.out.println(name);
                List<Music> musicList = album.getMusicList();
                for (Music music : musicList) {
                    String musicName = music.getMusicName();
                    String musicDuration = music.getMusicDuration();
                    writer.write("\t歌曲名称:" + musicName + " " + "\t歌曲时长:" + musicDuration + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private static List<Album> getAlbums() {
        //创建一个专辑集合
        List<Album> albums = new ArrayList<>();
        //创建一个专辑
        Album jay = new Album();
        albums.add(jay);
        //给专辑名字
        jay.setName("Jay");
        //创建一个音乐集合
        List<Music> musicList = new ArrayList<>();
        jay.setMusicList(musicList);

        Music music1 = new Music();
        music1.setMusicName("短发");
        music1.setMusicDuration("170");
        musicList.add(music1);
        Music music2 = new Music();
        music2.setMusicName("PUMM");
        music2.setMusicDuration("200");
        musicList.add(music2);

        Album ZJL = new Album();
        albums.add(ZJL);
        ZJL.setName("ZJL");
        List<Music> musicList2 = new ArrayList<>();
        ZJL.setMusicList(musicList2);

        Music music3 = new Music();
        music3.setMusicName("菊花台");
        music3.setMusicDuration("250");
        Music music4 = new Music();
        music4.setMusicName("公公偏头痛");
        music4.setMusicDuration("190");
        musicList2.add(music3);
        musicList2.add(music4);

        Album HCY = new Album();
        albums.add(HCY);
        HCY.setName("华晨宇");
        List<Music> musicList3 = new ArrayList<>();
        HCY.setMusicList(musicList3);

        Music music5 = new Music();
        music5.setMusicName("异类");
        music5.setMusicDuration("300");
        Music music6 = new Music();
        music6.setMusicName("我管你");
        music6.setMusicDuration("150");
        musicList3.add(music5);
        musicList3.add(music6);
        return albums;
    }
}
