package Repository.Customer;

import Model.Customer;

import java.util.List;

public interface ICustomerRepo {
    List<Customer> findAll();
    void add(Customer customer);
//    void edit(Customer customer);
//    void findID(int id);
//    void delete(int id);
}
