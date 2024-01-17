package org.example.furama4.service.employee;

import org.example.furama4.model.employee.EducationDegree;

import java.util.List;

public interface IEducationDegreeService {
    EducationDegree findByName(String educationDegreeName);
    EducationDegree findById(int id);
    List<EducationDegree> findAll();
}
