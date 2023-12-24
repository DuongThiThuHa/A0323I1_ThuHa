package org.example.cart.service;

import org.example.cart.model.Product;
import org.example.cart.repository.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
@Autowired
    private IProductRepo iProductRepo;


    @Override
    public Product create(Product product) {
      return iProductRepo.save(product);
    }

    @Override
    public boolean deleteById(int id) {
        iProductRepo.deleteById(id);
        return true;
    }

    @Override
    public List< Product > findAll() {
       return iProductRepo.findAll();
    }

    @Override
    public Product findById(int id) {
        return iProductRepo.findById(id).orElse(null);
    }
}
