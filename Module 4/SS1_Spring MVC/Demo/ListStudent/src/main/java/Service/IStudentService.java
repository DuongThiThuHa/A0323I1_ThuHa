package Service;

import Model.Student;

import java.util.List;

public interface IStudentService {
    void createOrUpdate(Student student);
    Student findByID(String id);
    void deleteById(String id);
    List<Student> findAll();
}
