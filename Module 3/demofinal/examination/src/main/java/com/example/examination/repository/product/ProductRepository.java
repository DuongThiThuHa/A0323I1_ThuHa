package com.example.examination.repository.product;

import com.example.examination.model.Category;
import com.example.examination.model.Product;
import com.example.examination.repository.BaseRepository;
import com.example.examination.repository.cateogry.CategoryRepository;
import com.example.examination.repository.cateogry.ICategoryRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository{
    private static final String SELECT_FROM_PRODUCT ="select * from product";
    private static final String DELETE_PRODUCT ="delete from product where id = ?";
    private static final String INSERT_INTO_PRODUCT ="insert into product(name,category_id) values (?,?);";
    private ICategoryRepository iCategoryRepository = new CategoryRepository();
    @Override
    public List<Product> showListProduct() {
        List<Product> list = new ArrayList<>();
        Category category = null;
        Connection connection = BaseRepository.getConnection();
        Product product = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_FROM_PRODUCT);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int categoryId = resultSet.getInt("category_id");
                category = iCategoryRepository.findCategoryById(categoryId);
                product = new Product(id,name,category);
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
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(INSERT_INTO_PRODUCT);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getCategory().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(DELETE_PRODUCT);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
