package org.example.service;

import org.example.model.Blog;

import java.util.List;

public interface IBlogService {
    void create(Blog blog);

    void update(Blog blog);

    Blog findById(int id);

    List<Blog> findAll();

    void deleteById(int id);
}
