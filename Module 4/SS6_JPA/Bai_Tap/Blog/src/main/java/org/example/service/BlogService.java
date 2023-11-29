package org.example.service;

import org.example.model.Blog;
import org.example.repository.IBlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepo iBlogRepo;
    @Override
    public void create(Blog blog) {
        iBlogRepo.save(blog);
    }

    @Override
    public void update(Blog blog) {
        iBlogRepo.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return iBlogRepo.findById(id).orElse(null);
    }

    @Override
    public List< Blog > findAll() {
        return iBlogRepo.findAll();
    }

    @Override
    public void deleteById(int id) {
        iBlogRepo.deleteById(id);
    }
}
