package org.example.repository;

import org.example.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepo implements IProductRepo {
    private static Map<Integer, Product> productMap;

    static {
        productMap = new HashMap<>();
        productMap.put(1, new Product(1, "laptop", 25000000, "AsusVivobook", "Asus"));
        productMap.put(1, new Product(2, "laptop", 23000000, "Asus", "Asus"));
        productMap.put(1, new Product(3, "laptop", 17000000, "HP", "HP"));
        productMap.put(1, new Product(4, "laptop", 21000000, "Lenovo", "Lenovo"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }

    @Override
    public void save(int id, Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> searchList = new ArrayList<>();
        for (Product product : productMap.values()){
            if (product.getName().contains(name)){
                searchList.add(product);
            }
        }
        return searchList;
    }
}
