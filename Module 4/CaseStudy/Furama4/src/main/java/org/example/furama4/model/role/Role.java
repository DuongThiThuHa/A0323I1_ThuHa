package org.example.furama4.model.role;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jdk.dynalink.linker.LinkerServices;

import java.util.List;

@Entity
@Table(name = "Role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int roleId;
    @Column(name = "role_name", columnDefinition = "varchar(255)")
    private String role_name;
    @OneToMany(mappedBy = "role")
    @JsonBackReference
    private List<UserRole> userRoleList;

    public Role() {
    }

    public Role(int roleId, String role_name, List< UserRole > userRoleList) {
        this.roleId = roleId;
        this.role_name = role_name;
        this.userRoleList = userRoleList;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public List< UserRole > getUserRoleList() {
        return userRoleList;
    }

    public void setUserRoleList(List< UserRole > userRoleList) {
        this.userRoleList = userRoleList;
    }
}
