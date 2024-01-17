package org.example.furama4.repository.employee;

import org.example.furama4.model.employee.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEducationDegreeRepo extends JpaRepository< EducationDegree,Integer > {
    EducationDegree findEducationDegreeName(String educationDegreeName);
}
