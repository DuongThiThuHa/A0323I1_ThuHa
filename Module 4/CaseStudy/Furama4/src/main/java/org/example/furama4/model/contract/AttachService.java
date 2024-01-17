package org.example.furama4.model.contract;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "AttachService")
public class AttachService {
    @Id
    @GeneratedValue
    @Column(name ="attach_service_id")
    private int attachServiceId;
    @Column(name = "attach_service_name",columnDefinition = "varchar(45)")
    private String attachServiceName;
    @Column(name = "attach_service_status",columnDefinition = "varchar(45)")
    private String attachServiceStatus;
    @Column(name = "attach_service_cost")
    private double attachServiceCost;
    @Column(name = "attach_service_unit")
    private int attachServiceUnit;
    @JsonBackReference
    @OneToMany(mappedBy = "attachService")
    private List<ContractDetail> contractDetailList;

    public AttachService() {
    }

    public AttachService(int attachServiceId, String attachServiceName, String attachServiceStatus, double attachServiceCost, int attachServiceUnit, List< ContractDetail > contractDetailList) {
        this.attachServiceId = attachServiceId;
        this.attachServiceName = attachServiceName;
        this.attachServiceStatus = attachServiceStatus;
        this.attachServiceCost = attachServiceCost;
        this.attachServiceUnit = attachServiceUnit;
        this.contractDetailList = contractDetailList;
    }

    public int getAttachServiceId() {
        return attachServiceId;
    }

    public void setAttachServiceId(int attachServiceId) {
        this.attachServiceId = attachServiceId;
    }

    public String getAttachServiceName() {
        return attachServiceName;
    }

    public void setAttachServiceName(String attachServiceName) {
        this.attachServiceName = attachServiceName;
    }

    public String getAttachServiceStatus() {
        return attachServiceStatus;
    }

    public void setAttachServiceStatus(String attachServiceStatus) {
        this.attachServiceStatus = attachServiceStatus;
    }

    public double getAttachServiceCost() {
        return attachServiceCost;
    }

    public void setAttachServiceCost(double attachServiceCost) {
        this.attachServiceCost = attachServiceCost;
    }

    public int getAttachServiceUnit() {
        return attachServiceUnit;
    }

    public void setAttachServiceUnit(int attachServiceUnit) {
        this.attachServiceUnit = attachServiceUnit;
    }

    public List< ContractDetail > getContractDetailList() {
        return contractDetailList;
    }

    public void setContractDetailList(List< ContractDetail > contractDetailList) {
        this.contractDetailList = contractDetailList;
    }
}
