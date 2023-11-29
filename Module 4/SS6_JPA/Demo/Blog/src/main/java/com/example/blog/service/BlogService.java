package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.repository.IBlogRepo;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepo iBlogRepo;


    @Override
    public void create(Blog blog) {
        blog.setReleasedDate(new Date());
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
    public List< Blog > findByCategory(int cateID) {
        return iBlogRepo.findAllBlogByCategoryID(cateID);
    }

    @Override
    public void deleteById(int id) {
        iBlogRepo.deleteById(id);
    }
}