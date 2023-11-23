package com.example.customer.repository;

import com.example.customer.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public class ProductRepo extends JpaRepository<Product, Integer> {
    public List<Product> findAllByNameContaining(String name);

    @Query("from Product product where product.name like :name")
    public List<Product> search(@Param("name") String name);
}
