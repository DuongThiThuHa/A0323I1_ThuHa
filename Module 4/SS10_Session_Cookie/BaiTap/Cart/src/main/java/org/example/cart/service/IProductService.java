package org.example.cart.service;

import org.example.cart.model.Product;

import java.util.List;

public interface IProductService {

    Product create(Product product);
    boolean deleteById(int id);
    List<Product> findAll();
    Product findById(int id);}
