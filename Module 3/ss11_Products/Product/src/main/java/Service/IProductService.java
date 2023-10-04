package Service;

import Model.Product;

import java.util.List;

public interface IProductService {
    void add(Product product);
    void update(Product product);
    void delete(Product product);
    Product findById(int id);
    List<Product> findAll();
}
