package org.example.blog.repository;

import org.example.blog.model.BlogCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogCategoryRepo extends JpaRepository< BlogCategory,Integer > {
}
