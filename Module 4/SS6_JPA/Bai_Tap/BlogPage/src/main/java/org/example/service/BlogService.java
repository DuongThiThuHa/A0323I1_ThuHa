package org.example.service;

import org.example.model.Blog;
import org.example.repository.IBlogRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepo iBlogRepo;
    @Override
    public List<Blog> findAll() {
        return iBlogRepo.findAll();
    }

    @Override
    public Blog findById(int id) {
        return iBlogRepo.findById(id);
    }

    @Override
    public void save(Blog blog) {
        iBlogRepo.save(blog);
    }

    @Override
    public void remove(int id) {
        iBlogRepo.remove(id);
    }
}
