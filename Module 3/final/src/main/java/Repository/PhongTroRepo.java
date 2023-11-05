package Repository;

import Model.PhongTro;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PhongTroRepo implements IPhongTroRepo{
    private static final String select ="SELECT * FROM final.phongtro;";
    private static final String findID = "INSERT INTO `final`.`phongtro` (`tenPhongTro`) VALUES (?);";
//    private static final String delete = "delete from phongtro where maPhongTro = ?;";

    List<PhongTro> phongTroList = new ArrayList<>();
    PhongTro phongTro = null;
    @Override
    public List<PhongTro> findAll() {
        try {
            Connection connection = BaseRepo.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()){
                int code = resultSet.getInt("maPhongTro");
                String name = resultSet.getString("tenPhongTro");
                phongTro = new PhongTro(code,name);
                phongTroList.add(phongTro);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return phongTroList;
    }

    @Override
    public PhongTro findByID(String id) {
        try {
            Connection connection = BaseRepo.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(findID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int code = resultSet.getInt(1);
                String name = resultSet.getString(2);
                phongTro = new PhongTro(code,name);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
