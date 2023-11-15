package org.example.repository;

import org.example.model.Product;

import java.util.List;

public interface IProductRepo {
    List<Product> findAll();
    Product findById(int id);
    void remove(int id);
    void save(int id,Product product);
    void update(int id, Product product);
    List<Product> findByName(String name);
}
