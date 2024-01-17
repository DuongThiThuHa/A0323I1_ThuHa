package org.example.furama4.model.service;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "service_type")
public class ServiceType {
    @Id
    @GeneratedValue
    @Column(name = "service_type_id")
    private int serviceTypeId;
    @Column(name = "service_type_name", columnDefinition = "varchar(45)")
    private String serviceTypeName;
    @JsonBackReference
    @OneToMany(mappedBy = "serviceType")
    List< Service > serviceList;

    public ServiceType() {
    }

    public ServiceType(String serviceTypeName, List< Service > serviceList) {
        this.serviceTypeName = serviceTypeName;
        this.serviceList = serviceList;
    }

    public int getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(int serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getServiceTypeName() {
        return serviceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }

    public List< Service > getServiceList() {
        return serviceList;
    }

    public void setServiceList(List< Service > serviceList) {
        this.serviceList = serviceList;
    }
}