package com.example.customer.repository;

import com.example.customer.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepo extends JpaRepository<Category,Integer> {

}
