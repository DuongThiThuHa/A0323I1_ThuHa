package org.example.furama4.model.employee;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "Position")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private int positionId;
    @Column(name = "position_name", columnDefinition = "varchar(45)")
    @NotNull
    private String positionName;
    @OneToMany(mappedBy = "position")
    @JsonBackReference
    private List<Employee> employeeList;

    public Position() {
    }

    public Position(int positionId, String positionName, List< Employee > employeeList) {
        this.positionId = positionId;
        this.positionName = positionName;
        this.employeeList = employeeList;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public List< Employee > getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List< Employee > employeeList) {
        this.employeeList = employeeList;
    }
}
