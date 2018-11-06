package com.lanou3g.文件解析;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lanou3g.entity.Album;
import com.lanou3g.entity.Music;


import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

public class J1 {
    public static void main(String[] args) throws Exception {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Album>>(){}.getType();
        Reader reader = new FileReader("album-list.json");
        List<Album> albumList = gson.fromJson(reader, type);
        for (Album album : albumList) {
            System.out.println(album.getAlbumName());
            List<Music> musicList = album.getMusicList();
            for (Music music : musicList) {
                System.out.println(music.getMusicName());
                System.out.println(music.getDuration());
            }
        }
    }
}
