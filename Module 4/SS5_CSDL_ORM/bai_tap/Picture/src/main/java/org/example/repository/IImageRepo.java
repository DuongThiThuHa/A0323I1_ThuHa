package org.example.repository;

import org.example.model.Image;

import java.util.List;

public interface IImageRepo {
    void save(Image image);

    List<Image> findAll();

}
