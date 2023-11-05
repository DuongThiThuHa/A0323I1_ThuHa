package Repository.Customer;

import Database.BaseDate;
import Model.Customer;
import Service.Customer.CustomerService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepo implements ICustomerRepo{

    private static final String findAll = "select * from customer; ";
    private static final String insert = "insert into customer(customer_type_id, customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address )"+
            "values( ?,?,?,?,?,?,?,?);";

    @Override
    public List<Customer> findAll() {
        List<Customer> customers;
        try {
            Connection connection = BaseDate.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(findAll);

            customers = new ArrayList<>();
            Customer customer = null;
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("customerID");
                String name = resultSet.getString("customerName");
                String birthday = resultSet.getString("customerBirthday");
                Boolean gender = resultSet.getBoolean("customerGender");
                String cardID = resultSet.getString("customerCardID");
                String phone = resultSet.getString("customerPhone");
                String email = resultSet.getString("customerEmail");
                String address = resultSet.getString("customerAddress ");
                int customerType = resultSet.getInt("customerType");
                customer = new Customer(id, name, birthday, gender, cardID, phone, email, address, customerType);
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
            Connection connection = BaseDate.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1,customer.getCustomerName());
            preparedStatement.setString(2,customer.getCustomerBirthday());
            preparedStatement.setBoolean(3,customer.isCustomerGender());
            preparedStatement.setString(4,customer.getCustomerCardID());
            preparedStatement.setString(5,customer.getCustomerPhone());
            preparedStatement.setString(6,customer.getCustomerEmail());
            preparedStatement.setString(7,customer.getCustomerAddress());
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
