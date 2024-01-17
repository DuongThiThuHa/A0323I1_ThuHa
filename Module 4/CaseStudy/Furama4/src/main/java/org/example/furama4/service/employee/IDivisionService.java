package org.example.furama4.service.employee;

import org.example.furama4.model.employee.Division;

import java.util.List;

public interface IDivisionService {
    Division findByName(String divisionName);
    Division findById(int id);
    List<Division> findAll();
}
