package Repository;

import Model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepo implements ICategoryRepo{
    private static final String select ="select * from category";
    private static final String insert ="select * from category where category_id = ?;";

    @Override
    public List<Category> showListCategory() {
        List<Category> list = new ArrayList<>();
        Connection connection = BaseRepo.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            Category category;
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                category = new Category(id,name);
                list.add(category);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public Category findCategoryById(int id) {
        Category category = null;
        try {
            Connection connection = BaseRepo.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int idCategory = resultSet.getInt("id");
                String name = resultSet.getString("name");

                category = new Category(idCategory,name);
            }
            return category;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
