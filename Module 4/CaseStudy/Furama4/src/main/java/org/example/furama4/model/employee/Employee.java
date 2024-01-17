package org.example.furama4.model.employee;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.apache.catalina.User;
import org.example.furama4.model.contract.Contract;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "employee_id")
    private int employeeId;
    @Column(name = "employee_name", columnDefinition = "varchar(45)")
    private String employeeName;
    @Column(name = "employee_birthday", columnDefinition = "DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date employeeBirthday;
    @Column(name = "employee_id_card", columnDefinition = "varchar(45)")
    private String employeeIdCard;
    @Column(name = "employee_salary")
    private double employeeSalary;
    @Column(name = "employee_phone", columnDefinition = "varchar(45)")
    private String employeePhone;
    @Column(name = "employee_email", columnDefinition = "varchar(45)")
    private String employeeEmail;
    @Column(name = "employee_address", columnDefinition = "varchar(45)")
    private String employeeAddress;
    @ManyToOne
    @JoinColumn(name = "username")
    private org.example.furama4.model.role.User user;
    @JsonBackReference
    @OneToMany(mappedBy = "employee")
    private List< Contract > contractList;
    @ManyToOne
    @JoinColumn(name = "division_id")
    private Division division;
    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;
    @ManyToOne
    @JoinColumn(name = "education_degree_id")
    private EducationDegree educationDegree;

    public Employee() {
    }

    public Employee(int employeeId, String employeeName, Date employeeBirthday, String employeeIdCard, double employeeSalary, String employeePhone, String employeeEmail, String employeeAddress, List< Contract > contractList, Division division, Position position, EducationDegree educationDegree, User user) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.employeeIdCard = employeeIdCard;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.contractList = contractList;
        this.division = division;
        this.position = position;
        this.educationDegree = educationDegree;
        this.user = (org.example.furama4.model.role.User) user;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Date getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(Date employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public List< Contract > getContractList() {
        return contractList;
    }

    public void setContractList(List< Contract > contractList) {
        this.contractList = contractList;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public User getUser() {
        return (User) user;
    }

    public void setUser(User user) {
        this.user = (org.example.furama4.model.role.User) user;
    }
}
