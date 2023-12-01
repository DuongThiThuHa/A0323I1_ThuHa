package com.example.blog.service;

import com.example.blog.model.Blog;

import java.util.List;

public interface IService<T> {
    boolean create(T t);
    boolean update(T t);
    T findById(int id);
    List<T> findAll();
    boolean deleteById(int id);

}
