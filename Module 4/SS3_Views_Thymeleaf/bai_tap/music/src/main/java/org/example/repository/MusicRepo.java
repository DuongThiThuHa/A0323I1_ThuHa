package org.example.repository;

import org.example.model.Music;

import java.util.ArrayList;
import java.util.List;

public class MusicRepo implements IMusicRepo{
    private static List<Music> musicList;
    static {
        musicList = new ArrayList<>();
        musicList.add(new Music("Co Nguoi","Vu Cat Tuong","Hien Dai","https://youtu.be/BhbETPFyuaY?si=rkqa8RmvFmkI924F"));
        musicList.add(new Music("Dau Mua","Trung Quan Idol","Hien Dai","https://youtu.be/pDYM_JBAnp4?si=wymqDfOk9wcJNKv3"));
    }
    @Override
    public List<Music> getAll() {
        return musicList;
    }

    @Override
    public void create(Music music) {
        musicList.add(music);
    }
}
