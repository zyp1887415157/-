package com.lanou3g.entity;

import java.util.List;

public class Album {

    private String albumName;
    private List<Music> musicList;


    @Override
    public String toString() {
        return "Album{" +
                "albumName='" + albumName + '\'' +
                ", musicList=" + musicList +
                '}';
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public List<Music> getMusicList() {
        return musicList;
    }

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }
}
