package Service.Employee;

import Model.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();
    void add(Employee employee);
}
