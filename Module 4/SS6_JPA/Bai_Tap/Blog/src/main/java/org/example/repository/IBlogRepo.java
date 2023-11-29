package org.example.repository;

import org.example.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepo extends JpaRepository< Blog,Integer> {
}
