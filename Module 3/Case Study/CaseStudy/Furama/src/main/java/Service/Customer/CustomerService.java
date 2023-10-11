package Service.Customer;

import Model.Customer;
import Repository.Customer.CustomerRepo;

import java.util.List;

public class CustomerService implements ICustomerService{
    private CustomerRepo customerRepo = new CustomerRepo();

    @Override
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }

    @Override
    public void add(Customer customer) {
        customerRepo.add(customer);
    }
//
//    @Override
//    public void findID(int id) {
//
//    }
//
//    @Override
//    public void edit(Customer customer) {
//
//    }
//
//    @Override
//    public void delete(int id) {
//
//    }
}
