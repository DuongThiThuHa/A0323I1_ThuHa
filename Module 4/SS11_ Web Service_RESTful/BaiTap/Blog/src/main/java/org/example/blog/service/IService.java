package org.example.blog.service;

import org.example.blog.model.Blog;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface IService<T> {
    void create(T t);
    void update(T t);
    T findById(Integer id);
    List<T> findAll();
    void deleteById(Integer id);
}
