package Repository.Employee;

import Model.Employee;

import java.util.List;

public interface IEmployeeRepo {
    List<Employee> findAll();
    boolean add(Employee employee);
}
