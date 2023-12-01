package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Slice;

import java.awt.print.Pageable;
import java.util.List;

public interface IBlogService extends IService<Blog> {
    List<Blog> findAllByName(String name);
    Slice< Blog > findAllSlice(Pageable pageable);
}
