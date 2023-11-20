package org.example.service;

import org.example.model.Image;
import org.example.repository.IImageRepo;
import org.example.repository.ImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImageService implements IImageService{
    @Autowired
    private IImageRepo iImageRepo = new ImageRepo();

    @Override
    public void save(Image image) {
        iImageRepo.save(image);
    }

    @Override
    public List<Image> findAll() {
        return iImageRepo.findAll();
    }
}
