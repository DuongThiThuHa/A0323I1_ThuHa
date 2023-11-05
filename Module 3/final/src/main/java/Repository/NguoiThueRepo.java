package Repository;

import Model.NguoiThue;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NguoiThueRepo implements INguoiThueRepo{
    private static final String select = " SELECT * FROM final.nguoithue;";
    private static final String findID = "INSERT INTO `final`.`nguoithue` (`tenNguoiThue`) VALUES (?);";
    List<NguoiThue> nguoiThueList = new ArrayList<>();
    NguoiThue nguoiThue = null;
    @Override
    public List<NguoiThue> findAll() {
        try {
            Connection connection = BaseRepo.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()){
                int code = resultSet.getInt("maNguoiThue");
                String name = resultSet.getString("tenNguoiThue");
                String phone = resultSet.getString("soDienThoai");
                nguoiThue = new NguoiThue(code,name,phone);
                nguoiThueList.add(nguoiThue);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return nguoiThueList;
    }

    @Override
    public NguoiThue findByID(int id) {
        try {
            Connection connection = BaseRepo.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(findID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int code = resultSet.getInt("maNguoiThue");
                String name = resultSet.getString("tenNguoiThue");
                String phone = resultSet.getString("soDienThoai");
                nguoiThue = new NguoiThue(code,name,phone);
                nguoiThueList.add(nguoiThue);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
