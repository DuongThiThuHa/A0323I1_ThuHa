package org.example.furama4.service.employee;

import org.example.furama4.model.employee.EducationDegree;
import org.example.furama4.repository.employee.IEducationDegreeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EducationDegreeService implements IEducationDegreeService{
    @Autowired
    private IEducationDegreeRepo iEducationDegreeRepo;
    @Override
    public EducationDegree findByName(String educationDegreeName) {
        return iEducationDegreeRepo.findEducationDegreeName(educationDegreeName);
    }

    @Override
    public EducationDegree findById(int id) {
        return iEducationDegreeRepo.findById(id).orElse(null);
    }

    @Override
    public List< EducationDegree > findAll() {
        return iEducationDegreeRepo.findAll();
    }
}
