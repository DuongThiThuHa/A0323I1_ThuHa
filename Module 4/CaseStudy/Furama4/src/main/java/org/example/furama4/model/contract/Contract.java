package org.example.furama4.model.contract;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.example.furama4.model.customer.Customer;
import org.example.furama4.model.employee.Employee;
import org.example.furama4.model.service.Service;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;
import java.util.List;

@Entity(name = "contract")
public class Contract {
    @Id
    @Column(name = "contract_id")
    private int contractId;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @Column(name = "contract_start_day")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date contractStartDay;
    @Column(name = "contract_end_day")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date contractEndDay;
    @Column(name = "contract_deposit")
    private double contractDeposit;
    @Column(name = "contract_total_money")
    private double contractTotalMoney;
    @JsonBackReference
    @OneToMany(mappedBy = "contract")
    private List<ContractDetail> contractDetailList;
    public Contract() {
    }

    public Contract(int contractId, Customer customer, Service service, Employee employee, Date contractStartDay, Date contractEndDay, double contractDeposit, double contractTotalMoney) {
        this.contractId = contractId;
        this.customer = customer;
        this.service = service;
        this.employee = employee;
        this.contractStartDay = contractStartDay;
        this.contractEndDay = contractEndDay;
        this.contractDeposit = contractDeposit;
        this.contractTotalMoney = contractTotalMoney;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getContractStartDay() {
        return contractStartDay;
    }

    public void setContractStartDay(Date contractStartDay) {
        this.contractStartDay = contractStartDay;
    }

    public Date getContractEndDay() {
        return contractEndDay;
    }

    public void setContractEndDay(Date contractEndDay) {
        this.contractEndDay = contractEndDay;
    }

    public double getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(double contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public double getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(double contractTotalMoney) {
        this.contractTotalMoney = contractTotalMoney;
    }
}
