package Repository;

import Model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentRepo implements IStudentRepo{
    private static Map<String,Student> studentMap;
    static {
        studentMap = new HashMap<>();
        studentMap.put("SV01",new Student("VS01","Nhi",22,"Da Nang"));
        studentMap.put("SV02",new Student("VS02","Ha",22,"Quang Nam"));
        studentMap.put("SV03",new Student("VS03","Toan",22,"Quang Ngai"));
        studentMap.put("SV04",new Student("VS04","Hoang",22,"Da Nang"));
    }
    @Override
    public void createOrUpdate(Student student) {
        studentMap.put(student.getId(),student);
    }

    @Override
    public Student findByID(String id) {
        return studentMap.get(id);
    }

    @Override
    public void deleteById(String id) {
        studentMap.remove(id);
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(studentMap.values());
    }
}
