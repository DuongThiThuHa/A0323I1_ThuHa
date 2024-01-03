package org.example.blog.repository;

import org.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface IBlogRepo extends JpaRepository< Blog, Integer > {
    List<Blog> findByBlogCategoryBlogCategoryId(Integer id);
    Page< Blog> findAll(Pageable pageable);
}
