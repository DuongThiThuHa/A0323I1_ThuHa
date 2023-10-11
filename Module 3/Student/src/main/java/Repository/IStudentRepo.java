package Repository;

import Model.Student;

import java.util.List;

public interface IStudentRepo {
    void add(Student student);

    void add(int id, Student student);

    List<Student> update(int id);
    List<Student> delete(int id);
    List<Student> findAll(int id);

}
