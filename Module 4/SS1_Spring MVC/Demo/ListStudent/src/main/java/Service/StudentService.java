package Service;

import Model.Student;
import Repository.IStudentRepo;
import Repository.StudentRepo;

import java.util.List;

public class StudentService implements IStudentService{
    IStudentRepo iStudentRepo = new StudentRepo();
    @Override
    public void createOrUpdate(Student student) {
        iStudentRepo.createOrUpdate(student);
    }

    @Override
    public Student findByID(String id) {
        return iStudentRepo.findByID(id);
    }

    @Override
    public void deleteById(String id) {
        iStudentRepo.deleteById(id);
    }

    @Override
    public List<Student> findAll() {
        return iStudentRepo.findAll();
    }
}
