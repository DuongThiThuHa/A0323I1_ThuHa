package Repository;

import Model.Category;
import Model.Product;

import java.awt.datatransfer.FlavorEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepo implements IProductRepo {
    private static final String select = "select * from products";
    private static final String delete = "delete from products where id = ?";
    private static final String insert = "insert into products(name,category_id) values (?,?);";
    private ICategoryRepo iCategoryRepo = new CategoryRepo();
    List<Product> list = new ArrayList<>();
    Product product = null;

    @Override
    public void edit(Product product) {

    }

    @Override
    public List<Product> showListProduct() {
        Category category = null;
        System.out.println("come here");
        Connection connection = BaseRepo.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int categoryId = resultSet.getInt("category_id");
                float price = resultSet.getFloat("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                category = iCategoryRepo.findCategoryById(categoryId);
                product = new Product(id, name, price, quantity, color, category);
                list.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void create(Product product) {
        try {
            PreparedStatement preparedStatement = BaseRepo.getConnection().prepareStatement(insert);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setFloat(2,product.getPrice());
            preparedStatement.setInt(3,product.getQuantity());
            preparedStatement.setString(4,product.getColor());
          preparedStatement.setInt(5,product.getCategory().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement preparedStatement = BaseRepo.getConnection().prepareStatement(delete);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
