package org.example.furama4.service.employee;

import org.example.furama4.model.employee.Position;

import java.util.List;

public interface IPositionService {
    Position findByName(String positionName);
    Position findById(int id);
    List<Position> findAll();
}
