package org.example.furama4.repository.employee;

import org.example.furama4.model.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPositionRepo extends JpaRepository< Position, Integer > {
    Position findPositionName(String positionName);
}
