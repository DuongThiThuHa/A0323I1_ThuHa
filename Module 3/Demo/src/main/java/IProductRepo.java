import java.util.List;

public interface IProductRepo {
    List<Product> showListProduct();
    void create(Product product);
    void delete(int id);
}
