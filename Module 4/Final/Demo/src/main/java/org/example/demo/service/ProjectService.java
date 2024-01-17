package org.example.demo.service;

import org.example.demo.model.Project;
import org.example.demo.repository.IProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService implements IProjectService {
    @Autowired
    private IProjectRepo iProjectRepo;
    @Override
    public boolean create(Project duAn) {
        iProjectRepo.save(duAn);
        return true;
    }

    @Override
    public boolean update(Project duAn) {
        iProjectRepo.save(duAn);
        return true;
    }

    @Override
    public Project findById(int id) {
        return iProjectRepo.findById(id).orElse(null);
    }

    @Override
    public List< Project > findAll() {
        return iProjectRepo.findAll();
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public List< Project > findAllByName(String project_name) {
        return iProjectRepo.findAll();
    }

    @Override
    public Page< Project > findAllAndPaging(Pageable pageable) {
        return iProjectRepo.findAll(pageable);
    }
}
