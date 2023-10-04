package Repository;

import Model.Product;

import java.util.List;

public interface IProductRepo {
    List<Product> findAll();
    void add(Product product);
    Product findById(int id);
    void update( Product product);
    void delete(Product product);
}
