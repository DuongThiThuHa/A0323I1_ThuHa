package org.example.exam.service;

import org.example.exam.model.Category;
import org.example.exam.repository.ICategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService{
    @Autowired
    private ICategoryRepo iCategoryRepo;
    @Override
    public boolean create(Category category) {
        iCategoryRepo.save(category);
        return true;
    }

    @Override
    public boolean deleteById(int id) {
        iCategoryRepo.deleteById(id);
        return true;
    }

    @Override
    public Category findById(int id) {
        return iCategoryRepo.findById(id).orElse(null);
    }

    @Override
    public List< Category > findAll() {
        return iCategoryRepo.findAll();
    }
}
