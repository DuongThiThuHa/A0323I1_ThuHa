package org.example.service;

import org.example.model.Book;
import org.example.model.Category;
import org.example.repository.ICategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepo iCategoryRepo;

    @Override
    public List< Book > findAll() {
        return iCategoryRepo.findAll();
    }

    @Override
    public boolean create(Category category) {
        iCategoryRepo.save(category);
        return true;
    }

    @Override
    public boolean edit(Category category) {
        iCategoryRepo.save(category);
        return false;
    }

    @Override
    public Category findById(int id) {
        return iCategoryRepo.findById(id);
    }

    @Override
    public boolean deleteById(int id) {
        return iCategoryRepo.deleteById(id);
    }
}
