package Repository;

import Model.NguoiThue;
import Model.PhongTro;
import Model.Rent;
import Service.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RentRepo implements IRentRepo {
    private IRentService iRentService = new RentService();
    private IPhongTroService iPhongTroService = new PhongTroService();
    private INguoiThueService iNguoiThueService = new NguoiThueService();
    private static final String select = "SELECT * FROM final.rent;";
    private static final String findID = "INSERT INTO `final`.`rent` (`id`, `maPhongTro`, `maNguoiThue`, `ngayBatDau`, `hinhThucThue`) VALUES (?,?, ?, ?, ?);";

    @Override
    public void add(Rent rent) {
        try (
                Connection connection = BaseRepo.getConnection();
                PreparedStatement statement = connection.prepareStatement(select);
        ) {
            statement.setInt(1, rent.getId());
            statement.setInt(2, rent.getPhongTro().getMaPhongTro());
            statement.setInt(3, rent.getNguoiThue().getMaNguoiThue());
            statement.setString(4, rent.getHinhThuc());
            statement.setDate(5, (java.sql.Date) new Date(rent.getNgayThue().getTime()));
            statement.setString(6, rent.getGhiChu());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Rent> findAll() {
        List<Rent> rentList = new ArrayList<>();
        try (Connection connection = BaseRepo.getConnection();
             PreparedStatement statement = connection.prepareStatement(findID);
        ) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                PhongTro phongTro = iPhongTroService.findByID(rs.getString(2));
                NguoiThue nguoiThue = iNguoiThueService.findByID(rs.getInt(3));
                java.util.Date ngayThue = rs.getDate(4);
                String HT = rs.getString(5);
                String Note = rs.getString(6);
                rentList.add(new Rent(id, phongTro, nguoiThue, ngayThue, HT, Note));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rentList;
    }
}
