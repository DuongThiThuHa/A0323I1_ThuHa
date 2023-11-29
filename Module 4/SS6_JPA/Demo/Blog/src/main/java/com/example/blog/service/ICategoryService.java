package com.example.blog.service;

import com.example.blog.model.Category;

import java.util.List;

public interface ICategoryService {
    void create(Category category);

    List<Category> findAll();

    Category findByID(int id);

    void deleteByID(int id);

    void update(Category category);
}
