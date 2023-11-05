package Repository;

import Model.Student;

import java.util.List;

public interface IStudentRepo {
    void createOrUpdate(Student student);
    Student findByID(String id);
    void deleteById(String id);
    List<Student> findAll();
}
