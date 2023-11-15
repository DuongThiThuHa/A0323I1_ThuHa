package org.example.service;

import org.example.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void remove(int id);
    Product findById(int id);
    void update(int id, Product product);
    List<Product> findByName(String name);
    void save(int id, Product product);
}
