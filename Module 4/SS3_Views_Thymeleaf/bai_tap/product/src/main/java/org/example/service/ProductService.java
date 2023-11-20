package org.example.service;

import org.example.model.Product;
import org.example.repository.IProductRepo;
import org.example.repository.ProductRepo;

import java.util.List;

public class ProductService implements IProductService{
    private IProductRepo iProductRepo = new ProductRepo();
    @Override
    public List<Product> findAll() {
        return iProductRepo.findAll();
    }

    @Override
    public void remove(int id) {
        iProductRepo.remove(id);
    }

    @Override
    public Product findById(int id) {
        return findById(id);
    }

    @Override
    public void update(int id, Product product) {
        update(id, product);
    }

    @Override
    public List<Product> findByName(String name) {
        return iProductRepo.findByName(name);
    }

    @Override
    public void save(int id, Product product) {
        save(id, product);
    }
}
