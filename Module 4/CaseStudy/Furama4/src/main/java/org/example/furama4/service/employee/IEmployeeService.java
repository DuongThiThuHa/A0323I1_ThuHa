package org.example.furama4.service.employee;

import org.example.furama4.model.employee.Employee;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface IEmployeeService {
    void create(Employee employee);
    void delete(int id);
    void fix(Employee employee);
    Employee findEmployeeById(int id);
    List<Employee> findAllEmployees();
    Page<Employee> findAll(Pageable pageable);

//    Page< Employee> findAll(org.springframework.data.domain.Pageable pageable);
}
