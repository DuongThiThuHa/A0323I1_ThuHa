package Service.Customer;

import Model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    void add(Customer customer);
//    void findID(int id);
//    void edit(Customer customer);
//    void delete(int id);

}
