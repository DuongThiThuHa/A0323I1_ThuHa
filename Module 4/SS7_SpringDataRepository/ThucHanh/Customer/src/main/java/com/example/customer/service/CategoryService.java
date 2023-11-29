package com.example.customer.service;

import com.example.customer.model.Category;
import com.example.customer.repository.ICategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepo iCategoryRepo;

    @Override
    public boolean create(Category category) {
        iCategoryRepo.save(category);
        return true;
    }

    @Override
    public boolean update(Category category) {
        iCategoryRepo.save(category);
        return true;
    }

    @Override
    public Category findById(int id) {
        return iCategoryRepo.findById(id).orElse(null);
    }

    @Override
    public List<Category> findAll() {
        return iCategoryRepo.findAll();
    }

    @Override
    public boolean deleteById(int id) {
        iCategoryRepo.deleteById(id);
        return true;
    }
}
