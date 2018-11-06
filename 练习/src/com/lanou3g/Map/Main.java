package com.lanou3g.Map;

import com.lanou3g.entity.Album;
import com.lanou3g.entity.Music;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Album> albumList = dfds();
        FileWriter writer = new FileWriter("Test.txt");
        for (Album album : albumList) {
            String albumName = album.getAlbumName();
            System.out.println(albumName);
            writer.write("\n专辑名称:" + albumName + "\n");
            List<Music> musicList = album.getMusicList();
            for (Music music : musicList) {
                String musicName = music.getMusicName();
                int musicDuration = music.getDuration();
                writer.write(musicName + " " + "\t歌曲时长:" + musicDuration + "\n");
            }
        }
        writer.close();
    }

    private static List<Album> dfds() {
        List<Album> albumList = new ArrayList<>();
        Album 周杰伦 = new Album();
        albumList.add(周杰伦);
        周杰伦.setAlbumName("周杰伦");
        List<Music> musicList = new ArrayList<>();
        Music music = new Music();
        music.setMusicName("短发");
        music.setDuration(170);
        Music music2 = new Music();
        music2.setMusicName("PUMM");
        music2.setDuration(200);
        musicList.add(music);
        musicList.add(music2);
        周杰伦.setMusicList(musicList);

        Album HCY = new Album();
        albumList.add(HCY);
        HCY.setAlbumName("华晨宇");
        List<Music> musicList3 = new ArrayList<>();
        HCY.setMusicList(musicList3);

        Music music5 = new Music();
        music5.setMusicName("异类");
        music5.setDuration(300);
        Music music6 = new Music();
        music6.setMusicName("我管你");
        music6.setDuration(150);
        musicList3.add(music5);
        musicList3.add(music6);
        return albumList;
    }
}
