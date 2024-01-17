package vn.service;

import vn.model.Category;
import vn.repository.ICategoryRepo;
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
    public boolean update(Category category) {
        iCategoryRepo.save(category);
        return true;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
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
