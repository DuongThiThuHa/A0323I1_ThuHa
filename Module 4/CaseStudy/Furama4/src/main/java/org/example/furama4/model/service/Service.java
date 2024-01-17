package org.example.furama4.model.service;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.example.furama4.model.contract.Contract;

import java.util.List;

@Entity
@Table(name = "Service")
public class Service {
    @Id
    @Column(name = "service_id")
    private int serviceId;
    @Column(name = "service_name", columnDefinition = "varchar(45)")
    private String serviceName;
    @Column(name = "service_area")
    private int serviceArea;
    @Column(name = "service_cost")
    private double serviceCost;
    @Column(name = "serive_max_people")
    private int serviceMaxPeople;
    @Column(name = "standard_room",columnDefinition = "varchar(45)")
    private String standardRoom;
    @Column(name = "description_other_convenience",columnDefinition = "varchar(45)")
    private String descriptionOtherConvenience;
    @Column(name = "pool_area")
    private double poolArea;
    @Column(name = "number_of_floors")
    private int numberOfFloors;
    @ManyToOne
    @JoinColumn(name = "rent_type_id")
    private RentType rentType;
    @ManyToOne
    @JoinColumn(name = "service_type_id")
    private ServiceType serviceType;

    @JsonBackReference
    @OneToMany(mappedBy = "service")
    private List< Contract > contractList;
    public Service() {
    }

    public Service(int serviceId, String serviceName, int serviceArea, double serviceCost, int serviceMaxPeople, String standardRoom, String descriptionOtherConvenience, double poolArea, int numberOfFloors, RentType rentType, ServiceType serviceType) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.serviceMaxPeople = serviceMaxPeople;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.rentType = rentType;
        this.serviceType = serviceType;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(int serviceArea) {
        this.serviceArea = serviceArea;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public int getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(int serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }
}
