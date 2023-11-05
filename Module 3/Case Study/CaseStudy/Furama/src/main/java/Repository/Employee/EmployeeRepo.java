package Repository.Employee;

import Model.Employee;
import Service.Employee.EmployeeService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepo implements IEmployeeRepo{
    EmployeeService employeeService = new EmployeeService();
    List<Employee> employees = new ArrayList<>();

    private String jdbcURL = "jdbc:mysql://127.0.0.1:3307/furama2";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    private static final String findAll = "select * from employee; ";
    private static final String insert = "insert into employee(employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id)" +
            "values( ?,?,?,?,?,?,?,?,?,?);";

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
    public List<Employee> findAll() {
        employees = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(findAll);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
//            private int employee_id;
//            private String employee_name;
//            private String employee_birthday;
//            private String employee_id_card;
//            private String employee_phone;
//            private String employee_email;
//            private String employee_degree;
//            private String position_id;
//            private String employee_salary;
            while(resultSet.next()){
                String name = resultSet.getString("employee_name");
                String birthday = resultSet.getString("employee_birthday");
                String cardID = resultSet.getString("employee_id_card");
                String phone = resultSet.getString("employee_phone");
                String email = resultSet.getString("employee_email");
                String degree = resultSet.getString("employee_degree");
                String position = resultSet.getString("position_id");
                String salary = resultSet.getString("employee_salary");
                employees.add(new Employee(name,birthday,cardID,phone,email,degree,position,salary));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public boolean add(Employee employee) {
        boolean rowEmployee;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setInt(1,employee.getEmployee_id());
            preparedStatement.setString(2,employee.getEmployee_name());
            preparedStatement.setString(3,employee.getEmployee_birthday());
            preparedStatement.setString(4,employee.getEmployee_id_card());
            preparedStatement.setString(5,employee.getEmployee_phone());
            preparedStatement.setString(6, employee.getEmployee_email());
            preparedStatement.setString(7, employee.getEmployee_degree());
            preparedStatement.setString(8, employee.getPosition_id());
            preparedStatement.setString(9, employee.getEmployee_salary());
            rowEmployee = preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowEmployee;

    }
}
