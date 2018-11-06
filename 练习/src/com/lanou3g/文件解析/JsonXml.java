package com.lanou3g.文件解析;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lanou3g.entity.Album;
import com.lanou3g.entity.Music;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

public class JsonXml {
    public static void main(String[] args) throws Exception {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Album>>() {
        }.getType();
        Reader reader = new FileReader("album-list.json");
        List<Album> albumList = gson.fromJson(reader, type);
        BufferedWriter writer = new BufferedWriter(new FileWriter("BB.txt"));
        try {
            for (Album album : albumList) {
                System.out.println(album.getAlbumName());
                writer.write(album.getAlbumName()+"\n");
                List<Music> musicList = album.getMusicList();
                for (Music music : musicList) {
                    System.out.println(music.getMusicName());
                    System.out.println(music.getDuration());
                    writer.write("   "+music.getMusicName()+",");
                    writer.write(Integer.toString(music.getDuration())+"\n");
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
}
