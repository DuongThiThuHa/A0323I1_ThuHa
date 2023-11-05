package com.example.examination.repository.product;

import com.example.examination.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> showListProduct();
    void create(Product product);
    void delete(int id);
}
