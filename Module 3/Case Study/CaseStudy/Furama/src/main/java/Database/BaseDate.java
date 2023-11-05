package Database;

import com.sun.security.auth.UnixNumericGroupPrincipal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDate {
    private static final String url = "jdbc:mysql://127.0.0.1:3307/furama2";
    private static final String username = "root";
    private static final String password = "123456";

    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
