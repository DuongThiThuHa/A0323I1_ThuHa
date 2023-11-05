package Repository;

import Model.Product;

import java.util.List;

public interface IProductRepo {
    void edit (Product product);
    List<Product> showListProduct();
    void create(Product product);
    void delete(int id);
}
