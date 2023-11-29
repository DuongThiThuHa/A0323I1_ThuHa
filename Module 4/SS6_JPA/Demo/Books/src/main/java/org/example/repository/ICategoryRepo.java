package org.example.repository;

import org.example.model.Category;
import org.example.service.IService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepo extends IService< Category > {
    void save(Category category);
}
