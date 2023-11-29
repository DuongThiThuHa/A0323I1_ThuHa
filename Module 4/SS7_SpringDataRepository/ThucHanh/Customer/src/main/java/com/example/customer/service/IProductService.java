package com.example.customer.service;

import com.example.customer.model.Product;

public interface IProductService extends IService<Product>{

    Product findAllByName(String name);
}
