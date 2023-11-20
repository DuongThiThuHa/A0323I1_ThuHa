package org.example.service;

import org.example.model.Music;
import org.example.repository.IMusicRepo;
import org.example.repository.MusicRepo;

import java.util.List;

public class MusicService implements IMusicService{
    private IMusicRepo iMusicRepo = new MusicRepo();
    @Override
    public List<Music> getAll() {
        return iMusicRepo.getAll();
    }

    @Override
    public void create(Music music) {
        iMusicRepo.create(music);
    }
}
