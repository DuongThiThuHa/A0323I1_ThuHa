package org.example.furama4.model.employee;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "EducationDegree")
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "education_degree_id")
    private int educationDegreeId;
    @Column(name = "education_degree_name", columnDefinition = "varchar(45)")
    private String educationDegreeName;
    @JsonBackReference
    @OneToMany(mappedBy = "educationDegree")
    private List<Employee> employeeList;

    public EducationDegree() {
    }

    public EducationDegree(int educationDegreeId, String educationDegreeName, List< Employee > employeeList) {
        this.educationDegreeId = educationDegreeId;
        this.educationDegreeName = educationDegreeName;
        this.employeeList = employeeList;
    }

    public int getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(int educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }

    public String getEducationDegreeName() {
        return educationDegreeName;
    }

    public void setEducationDegreeName(String educationDegreeName) {
        this.educationDegreeName = educationDegreeName;
    }

    public List< Employee > getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List< Employee > employeeList) {
        this.employeeList = employeeList;
    }
}
