package org.example.exam.service;

import org.example.exam.model.Blog;
import org.example.exam.repository.IBlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepo iBlogRepo;


    @Override
    public List< Blog > findAllByTitle(String title) {
        return iBlogRepo.findAllByTitleContaining(title);
    }

    @Override
    public boolean create(Blog blog) {
        iBlogRepo.save(blog);
        return true;
    }

    @Override
    public boolean deleteById(int id) {
        iBlogRepo.deleteById(id);
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
}
