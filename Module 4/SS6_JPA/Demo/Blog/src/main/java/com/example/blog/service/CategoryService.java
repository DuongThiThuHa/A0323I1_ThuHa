package com.example.blog.service;

import com.example.blog.model.Category;
import com.example.blog.repository.ICategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepo iCategoryRepo;


    @Override
    public void create(Category category) {
        iCategoryRepo.save(category);
    }

    @Override
    public List< Category > findAll() {
        return iCategoryRepo.findAll();
    }

    @Override
    public Category findByID(int id) {
        return iCategoryRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteByID(int id) {
        iCategoryRepo.deleteById(id);
    }

    @Override
    public void update(Category category) {
        iCategoryRepo.save(category);
    }
}
