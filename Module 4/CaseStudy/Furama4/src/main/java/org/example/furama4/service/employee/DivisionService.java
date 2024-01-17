package org.example.furama4.service.employee;

import org.example.furama4.model.employee.Division;
import org.example.furama4.repository.employee.IDivisionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService implements IDivisionService{
    @Autowired
    private IDivisionRepo iDivisionRepo;

    @Override
    public Division findByName(String divisionName) {
        return iDivisionRepo.findDivisionName(divisionName);
    }

    @Override
    public Division findById(int id) {
        return iDivisionRepo.findById(id).orElse(null);
    }

    @Override
    public List< Division > findAll() {
        return iDivisionRepo.findAll();
    }
}
