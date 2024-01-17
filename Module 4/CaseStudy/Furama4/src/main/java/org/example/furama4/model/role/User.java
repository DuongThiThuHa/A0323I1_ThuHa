package org.example.furama4.model.role;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.example.furama4.model.employee.Employee;

import java.util.List;

@Entity
@Table(name = "User")
public class User {
    @Id
    @Column(name = "username", columnDefinition = "varchar(255)")
    private String username;
    @Column(name = "password", columnDefinition = "varchar(255)")
    private String password;
    @JsonBackReference
    @OneToMany(mappedBy = "user")
    private List< UserRole > userRoleList;
    @JsonBackReference
    @OneToMany(mappedBy = "user")
    List< Employee > employeeList;

    public User() {
    }

    public User(String username, String password, List< UserRole > userRoleList) {
        this.username = username;
        this.password = password;
        this.userRoleList = userRoleList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List< UserRole > getUserRoleList() {
        return userRoleList;
    }

    public void setUserRoleList(List< UserRole > userRoleList) {
        this.userRoleList = userRoleList;
    }
}
