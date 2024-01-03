package org.example.blog.service;

import org.example.blog.model.Blog;
import org.example.blog.repository.IBlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BlogService implements IService< Blog > {
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
    public Blog findById(Integer id) {
        return iBlogRepo.findById(id).orElse(null);
    }

    @Override
    public List< Blog > findAll() {
        return iBlogRepo.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        iBlogRepo.deleteById(id);
    }
}
