package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.repository.IBlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepo iBlogRepo;
    @Override
    public boolean create(Blog blog) {
        iBlogRepo.save(blog);
        return true;
    }

    @Override
    public boolean update(Blog blog) {
        iBlogRepo.save(blog);
        return true;
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
    public boolean deleteById(int id) {
        iBlogRepo.deleteById(id);
        return true;
    }

    @Override
    public List< Blog > findAllByName(String name) {
        return iBlogRepo.findAllByNameContaining(name);
    }

    @Override
    public Slice< Blog > findAllSlice(Pageable pageable) {
        return iBlogRepo.findAll(pageable);
    }


}
