package com.example.blog.service;

import com.example.blog.model.Blog;
import org.hibernate.query.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface IBlogService {
    void create(Blog blog);

    void update(Blog blog);

    Blog findById(int id);

    List<Blog> findAll();

    List<Blog> findByCategory(int cateID);

    void deleteById(int id);
}
