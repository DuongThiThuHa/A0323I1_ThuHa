package org.example.furama4.repository.employee;

import org.example.furama4.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepo extends JpaRepository< Employee, Integer > {
}
