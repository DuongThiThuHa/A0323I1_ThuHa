package org.example.exam.service;

import org.example.exam.model.Blog;

import java.util.List;

public interface IBlogService extends IService< Blog> {
    List<Blog> findAllByTitle(String title);
}
