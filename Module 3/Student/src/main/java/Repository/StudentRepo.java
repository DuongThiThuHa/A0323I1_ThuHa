package Repository;

import Model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class StudentRepo implements IStudentRepo {
private static final String SelectStudent = "select * from student;";
private static final String update = "update student set student.id = ? , student.name = ? , student.dateOfBirth = ? , student.address = ? , student.email = ?;";
private static final String delete = "delete from student where student.id = ?;" ;
private static final String findId = "select * from student where id =?;";
private static final String insert = "insert into student(name,dateOfBirth,address,email) values(?,?,?,?);";

    @Override
    public void add(Student student) {
        Connection connection = BaseRepo.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getDateOfBirth());
            preparedStatement.setString(3,student.getAddress());
            preparedStatement.setString(4,student.getEmail());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(int id, Student student) {
        //Thiết lập kết nối với JDBC
        Connection connection = BaseRepo.getConnection();
        try {
        //Thiết lập kết nối đến cơ sở dữ liệu.
            PreparedStatement preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getDateOfBirth());
            preparedStatement.setString(3,student.getAddress());
            preparedStatement.setString(4,student.getEmail());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> update(int id) {
        return null;
    }

    @Override
    public List<Student> delete(int id) {
        return null;
    }

    @Override
    public List<Student> findAll(int id) {
        return null;
    }
}
