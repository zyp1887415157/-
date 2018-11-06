package com.lanou3g.entity;

public class Music {


    private String musicName;
    private int duration;

    @Override
    public String toString() {
        return "Music{" +
                "musicName='" + musicName + '\'' +
                ", duration=" + duration +
                '}';
    }

    public String getMusicName() {
        return musicName;
    }

    public Music setMusicName(String musicName) {
        this.musicName = musicName;
        return this;
    }

    public int getDuration() {
        return duration;
    }

    public Music setDuration(int duration) {
        this.duration = duration;
        return this;
    }
}
