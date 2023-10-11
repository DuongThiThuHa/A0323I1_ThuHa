package Repository;

import java.sql.Connection;


public class BaseRepo {
    private static final String jdbcURL = "jdbc:mysql://127.0.0.1:3307/student";
    private static final String jdbcUsername = "root";
    private static final String jdbcPassword = "123456";

    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

}
