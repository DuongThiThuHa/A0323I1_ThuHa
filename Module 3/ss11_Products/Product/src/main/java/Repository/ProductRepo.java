package Repository;

import Model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepo implements IProductRepo {
    private static Map<Integer,Product> products;
    static {
        products = new HashMap<>();
        products.put(1,new Product(1,"Điện thoại Oppo",20000,"còn hàng"));
        products.put(2,new Product(2,"Điện thoại SamSung",50000,"còn hàng"));
        products.put(3,new Product(3,"Điện Thoại Nokia",100000,"còn hàng"));
        products.put(4,new Product(4,"Điện thoại iPhone",32000,"còn hàng"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void add(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void delete(Product product) {
        products.remove(product.getId());
    }
}
