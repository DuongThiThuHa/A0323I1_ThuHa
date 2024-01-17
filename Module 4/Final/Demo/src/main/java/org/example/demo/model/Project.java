package org.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.util.Date;

@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private int project_id;
    @Column(name = "project_name", columnDefinition = "varchar(100)")
    private String project_name;
    @Column(name = "price")
    @NumberFormat(pattern = "#.###")
    private double price;
    @Column(name = "des", columnDefinition = "varchar(255)")
    private String des;
    @Column(name = "time")
    private String time;
    @Column(name = "day")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id")
    private Company company;

    public Project() {
    }

    public Project(int project_id, String project_name, double price, String des, String time, Date date, Company company) {
        this.project_id = project_id;
        this.project_name = project_name;
        this.price = price;
        this.des = des;
        this.time = time;
        this.date = date;
        this.company = company;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
