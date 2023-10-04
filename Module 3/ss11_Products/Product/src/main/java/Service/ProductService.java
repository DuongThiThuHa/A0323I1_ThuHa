package Service;

import Model.Product;
import Repository.ProductRepo;

import java.util.List;

public class ProductService implements IProductService{
    private ProductRepo productRepo = new ProductRepo();
    @Override
    public void add(Product product) {
        productRepo.add(product);
    }

    @Override
    public void update(Product product) {
        productRepo.update(product);
    }

    @Override
    public void delete(Product product) {
        productRepo.delete(product);
    }

    @Override
    public Product findById(int id) {
        return productRepo.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }
}
