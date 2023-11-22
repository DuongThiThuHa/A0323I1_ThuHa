package org.example.service;

import org.example.model.Customer;
import org.example.repository.CustomerRepo;
import org.example.repository.ICustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.PersistenceContext;
import java.util.List;

public class CustomerService implements ICustomerService{
    private ICustomerRepo iCustomerRepo = new CustomerRepo();
    @Override
    public List<Customer> findAll() {
        return iCustomerRepo.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return iCustomerRepo.findById(id);
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepo.save(customer);
    }

    @Override
    public void remove(Long id) {
        iCustomerRepo.remove(id);
    }
}
