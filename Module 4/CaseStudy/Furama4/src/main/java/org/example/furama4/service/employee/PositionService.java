package org.example.furama4.service.employee;

import org.example.furama4.model.employee.Position;
import org.example.furama4.repository.employee.IPositionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService implements IPositionService {
    @Autowired
    private IPositionRepo iPositionRepo;

    @Override
    public Position findByName(String positionName) {
        return iPositionRepo.findPositionName(positionName);
    }

    @Override
    public Position findById(int id) {
        return iPositionRepo.findById(id).orElse(null);
    }

    @Override
    public List< Position > findAll() {
        return iPositionRepo.findAll();
    }
}
