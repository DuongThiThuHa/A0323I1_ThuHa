package Service;

import Model.Student;
import Repository.StudentRepo;

import java.util.List;

public class StudentService implements IStudentService{
StudentRepo studentRepo = new StudentRepo();
    @Override
    public void add(Student student) {
        studentRepo.add(student);
    }

    @Override
    public List<Student> update(Student student) {
        return null;
    }

    @Override
    public List<Student> delete(int id) {
        return null;
    }

    @Override
    public List<Student> findAll() {
        return null;
    }
}
