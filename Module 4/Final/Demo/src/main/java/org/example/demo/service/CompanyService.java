package org.example.demo.service;

import org.example.demo.model.Company;
import org.example.demo.repository.ICompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService implements ICompanyService {
    @Autowired
    private ICompanyRepo iCompanyRepo;
    @Override
    public boolean create(Company doanhNghiep) {
        iCompanyRepo.save(doanhNghiep);
        return true;
    }

    @Override
    public boolean update(Company doanhNghiep) {
        iCompanyRepo.save(doanhNghiep);
        return true;
    }

    @Override
    public Company findById(int id) {
        return iCompanyRepo.findById(id).orElse(null);
    }

    @Override
    public List< Company > findAll() {
        return iCompanyRepo.findAll();
    }

    @Override
    public boolean deleteById(int id) {
        iCompanyRepo.deleteById(id);
        return true;
    }

    @Override
    public List< Company > findAllByName(String tenDoanhNghiep) {
        return iCompanyRepo.findAllByNameContaining(tenDoanhNghiep);
    }

    @Override
    public Page< Company > findAllAndPaging(Pageable pageable) {
        return iCompanyRepo.findAll(pageable);
    }
}