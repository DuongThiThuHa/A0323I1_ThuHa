package org.example.service;

import org.example.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> getAll();
    void create(Music music);
}
