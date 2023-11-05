import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepo implements ICategoryRepo{
    List<Category> categoryList = new ArrayList<>();
    Category category = null;
    private static final String select = "select * from category; ";
    private static final String findID = " select * from category where id = ?";

    @Override
    public List<Category> showListCategory() {
        try {
            Connection connection = BaseRepo.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                category = new Category(id,name);
                categoryList.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categoryList;
    }

    @Override
    public Category findCategoryById(int id) {
        try {
            Connection connection = BaseRepo.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(findID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int idCategory = resultSet.getInt("id");
                String name  = resultSet.getString("name");
                category = new Category(idCategory,name);
            }
            return category;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
