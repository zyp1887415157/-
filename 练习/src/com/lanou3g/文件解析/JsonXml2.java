package com.lanou3g.文件解析;

import com.google.gson.Gson;
import com.lanou3g.entity.Album;
import com.lanou3g.entity.Music;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JsonXml2 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("BB.txt"));
        String line ="";
        List<Music> musicList = new ArrayList<>();
        List<Album> albumList = new ArrayList<>();
        Album album = new Album();
        while ((line=reader.readLine())!=null){
            if (line.startsWith("   ")){
                String musicStr = line.trim();
                String[] split1 = musicStr.split(",");
//                String[] split = line.split(",");
                String name = split1[0];
                int duration = Integer.parseInt(split1[1]);
                Music music = new Music();
                music.setMusicName(name.trim());
                music.setDuration(duration);
                musicList.add(music);
            }else {
                album.setAlbumName(line);
                albumList.add(album);
//                System.out.println(album.getAlbumName());
                musicList = new ArrayList<>();
                album.setMusicList(musicList);
            }
        }
        Gson gson = new Gson();
        Writer writer = new FileWriter("BB.json");
        String s = gson.toJson(albumList);
        writer.write(s);
        writer.close();
    }
}
