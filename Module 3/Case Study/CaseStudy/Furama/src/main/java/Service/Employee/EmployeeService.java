package Service.Employee;

import Model.Employee;
import Repository.Employee.EmployeeRepo;

import java.util.List;

public class EmployeeService implements IEmployeeService{
    EmployeeRepo employeeRepo = new EmployeeRepo();

    @Override
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    @Override
    public void add(Employee employee) {
        employeeRepo.add(employee);
    }
}
