package com.example.blog.repository;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.List;

public interface IBlogRepo extends JpaRepository< Blog, Integer > {
    public List<Blog> findAllByNameContaining(String name);
    @Query("From Blog blog where blog.name like :name")
    public List<Blog> search(@Param("name") String name);

    Slice< Blog> findAll(Pageable pageable);
}
