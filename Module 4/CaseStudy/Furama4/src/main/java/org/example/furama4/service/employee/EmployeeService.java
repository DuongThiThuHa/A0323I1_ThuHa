package org.example.furama4.service.employee;

import org.example.furama4.model.employee.Employee;
import org.example.furama4.repository.employee.IEmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class EmployeeService implements IEmployeeService{
    @Autowired
    private IEmployeeRepo iEmployeeRepo;
    @Override
    public void create(Employee employee) {
        iEmployeeRepo.save(employee);
    }

    @Override
    public void delete(int id) {
       iEmployeeRepo.deleteById(id);
    }

    @Override
    public void fix(Employee employee) {
        iEmployeeRepo.save(employee);
    }

    @Override
    public Employee findEmployeeById(int id) {
        return iEmployeeRepo.findById(id).orElse(null);
    }

    @Override
    public List< Employee > findAllEmployees() {
        return iEmployeeRepo.findAll();
    }

    @Override
    public Page< Employee > findAll(Pageable pageable) {
        return iEmployeeRepo.findAll((org.springframework.data.domain.Pageable) pageable);
    }
}
