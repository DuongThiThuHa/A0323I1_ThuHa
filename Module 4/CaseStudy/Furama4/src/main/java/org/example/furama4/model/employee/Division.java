package org.example.furama4.model.employee;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Division")
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")
    private int divisionId;
    @Column(name = "division_name", columnDefinition = "varchar(45)")
    private String divisionName;
    @JsonBackReference
    @OneToMany(mappedBy = "division")
    private List<Employee> employeeList;

    public Division() {
    }

    public Division(int divisionId, String divisionName, List< Employee > employeeList) {
        this.divisionId = divisionId;
        this.divisionName = divisionName;
        this.employeeList = employeeList;
    }

    public int getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public List< Employee > getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List< Employee > employeeList) {
        this.employeeList = employeeList;
    }
}
