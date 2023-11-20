package org.example.service;

import org.example.model.Image;

import java.util.List;

public interface IImageService {
    void save(Image image);

    List<Image> findAll();
}
