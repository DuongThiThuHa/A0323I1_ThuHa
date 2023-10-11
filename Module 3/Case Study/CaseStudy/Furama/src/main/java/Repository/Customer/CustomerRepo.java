package Repository.Customer;

import Model.Customer;
import Model.CustomerType;
import Service.Customer.CustomerService;
import com.mysql.cj.jdbc.DatabaseMetaData;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomerRepo implements ICustomerRepo{
    private CustomerService customerService = new CustomerService();
    List<Customer> customers;

    private String jdbcURL = "jdbc:mysql://127.0.0.1:3307/furama2";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    private static final String findAll = "select * from customer; ";
    private static final String insert = "insert into customer(customer_type_id, customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address )"+
            "values( ?,?,?,?,?,?,?,?);";


    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<Customer> findAll() {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(findAll);

            customers = new ArrayList<>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String birthday = resultSet.getString("birthday");
                Boolean gender = resultSet.getBoolean("gender");
                String cardID = resultSet.getString("cardID");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address ");
                int CustomerType = resultSet.getInt("CustomerType");
                Customer customer = new Customer(id,name,birthday,gender,cardID,phone,email,address,CustomerType);
                customers.add(new Customer(customer));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customers;
    }

    @Override
    public void add(Customer customer) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1,customer.getName());
            preparedStatement.setString(2,customer.getBirthday());
            preparedStatement.setBoolean(3,customer.isGender());
            preparedStatement.setString(4,customer.getCardID());
            preparedStatement.setString(5,customer.getPhone());
            preparedStatement.setString(6,customer.getEmail());
            preparedStatement.setString(7,customer.getAddress());
            preparedStatement.setInt(8,customer.getCustomerType());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    @Override
//    public void edit(Customer customer) {
//
//    }
//
//    @Override
//    public void findID(int id) {
//
//    }
//
//    @Override
//    public void delete(int id) {
//
//    }
}
