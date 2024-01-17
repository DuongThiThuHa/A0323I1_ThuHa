package org.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "DoanhNghiep")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", columnDefinition = "varchar(100)")
    private String name;

    @Column(name = "category", columnDefinition = "varchar(100)")
    private String category;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email", columnDefinition = "varchar(50)")
    private String email;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "project_id")
    @JsonBackReference
    private List< Project > projects;

    public Company() {
    }

    public Company(int id, String name, String category, String phone, String email, String address, List< Project > projects) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.projects = projects;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List< Project > getProjects() {
        return projects;
    }

    public void setProjects(List< Project > projects) {
        this.projects = projects;
    }
}
