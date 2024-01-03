package org.example.blog.service;

import org.example.blog.model.BlogCategory;
import org.example.blog.repository.IBlogCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogCategoryService implements IService< BlogCategory > {
    @Autowired
    private IBlogCategoryRepo iBlogCategoryRepo;

    @Override
    public void create(BlogCategory blogCategory) {
        iBlogCategoryRepo.save(blogCategory);
    }

    @Override
    public void update(BlogCategory blogCategory) {
        iBlogCategoryRepo.save(blogCategory);
    }

    @Override
    public BlogCategory findById(Integer id) {
        return iBlogCategoryRepo.findById(id).orElse(null);
    }

    @Override
    public List< BlogCategory > findAll() {
        return iBlogCategoryRepo.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        iBlogCategoryRepo.deleteById(id);
    }
}
