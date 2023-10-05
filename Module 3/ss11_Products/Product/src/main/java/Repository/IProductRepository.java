package Repository;


import Model.Product;

import java.util.List;

public interface IProductRepository {
    void add(Product product);

    void update(Product product);

    void delete(Product product);

    Product findByID(int id);

    List<Product> findAll();
}
