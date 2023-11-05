import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepo implements IProductRepo{
    private static final String select = " select * from product;";
    private static final String delete = "delete from product where id = ?";
    private static final String insert = "insert into product (name,categoryID) values (?,?)";
    private ICategoryRepo iCategoryRepo = new CategoryRepo();
    List<Product> productList = new ArrayList<>();
    Category category = null;
    Product product = null;
    @Override
    public List<Product> showListProduct() {
        try {
            Connection connection = BaseRepo.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int category_id = resultSet.getInt("category_id");
                category = iCategoryRepo.findCategoryById(category_id);
                product = new Product(id,name,category);
                productList.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }

    @Override
    public void create(Product product) {
        Connection connection = BaseRepo.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setInt(1,product.getId());
            preparedStatement.setString(2,product.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try {
            Connection connection = BaseRepo.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
