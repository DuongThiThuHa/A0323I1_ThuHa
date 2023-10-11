package Service;

import Model.Student;

import java.util.List;

public interface IStudentService {
    void add(Student student);
    List<Student> update(Student student);
    List<Student> delete(int id);
    List<Student> findAll();


}
