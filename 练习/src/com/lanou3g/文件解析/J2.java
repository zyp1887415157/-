package com.lanou3g.文件解析;



import com.google.gson.Gson;
import com.lanou3g.entity.Album;
import com.lanou3g.entity.Music;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class J2 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("BB.txt"));
        String line = "";
        List<Album> albumList = new ArrayList<>();
        List<Music> musicList = new ArrayList<>();
        Album album = new Album();
        while ((line = reader.readLine()) != null) {
            if (line.startsWith(" ")) {
                String trim = line.trim();
                String[] split = trim.split(",");
                String name = split[0];
                int duration = Integer.parseInt(split[1]);
                Music music = new Music();
                music.setMusicName(name);
                music.setDuration(duration);
                musicList.add(music);
            } else {
                album.setAlbumName(line);
                musicList = new ArrayList<>();
                album.setMusicList(musicList);
                albumList.add(album);
            }
        }
        Gson gson = new Gson();
        Writer writer = new FileWriter("BB.json");
        String s = gson.toJson(albumList);
        writer.write(s);
        writer.close();
    }
}
