package org.example.furama4.repository.employee;

import org.example.furama4.model.employee.Division;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDivisionRepo extends JpaRepository< Division, Integer > {
    Division findDivisionName(String divisionName);
}
