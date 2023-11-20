package com.example.demo_ss5.repository;


import com.example.demo_ss5.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ProductRepo implements IProductRepo{
    @Autowired
    ICategoryRepo iCategoryRepo;
    public ProductRepo(){}

    @PersistenceContext
//    Vung nho luu tru doi tuong lay tu DB
    private EntityManager entityManager;
    @Override
    public boolean create(Product product) {
        entityManager.persist(product);
        return true;
    }

    @Override
    public boolean update(Product product) {
        entityManager.merge(product);
        return true;
    }

    @Override
    public Product findById(int id) {
         return entityManager.find(Product.class,id);
    }

    @Override
    public List<Product> findAll() {

        return entityManager.createQuery("From Product").getResultList();
    }

    @Override
    public boolean deleteById(int id) {
        entityManager.remove(findById(id));
        return true;
    }
}
