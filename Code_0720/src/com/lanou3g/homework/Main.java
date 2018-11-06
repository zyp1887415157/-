package com.lanou3g.homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/*
replaceAll
spilt


可以使用正则表达式
 */

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("test.txt"));
        List<Music> musicList = new ArrayList<>();
        List<Album> albumList = new ArrayList<>();
        String line = "";
        while ((line = br.readLine()) != null) {
            if (!line.startsWith(" ")) {
                Album album = new Album();
                musicList = new ArrayList<>();
                album.setName(line);
                albumList.add(album);
                album.setMusicList(musicList);
            } else {
                Music music = new Music();
                String trim = line.trim();
                music.setMusicName(trim);
                musicList.add(music);
            }
        }
        for (Album album1 : albumList) {
            String name = album1.getName();
            System.out.println("专辑名:" + name);
            List<Music> musicList1 = album1.getMusicList();
            for (Music music : musicList1) {
                System.out.println("\t歌曲名:" + music.getMusicName());
            }
        }
    }
}
