package Service;

import Model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService implements ICustomerService{
    private static Map<Integer, Customer> customerMap;

    static {
        customerMap = new HashMap<>();
        customerMap.put(1,new Customer(1,"Duong A","duonga@gmail.com","Quang Nam"));
        customerMap.put(2,new Customer(2,"Duong B","duongb@gmail.com","Quang Ninh"));
        customerMap.put(3,new Customer(3,"Duong C","duongc@gmail.com","Quang Ngai"));
        customerMap.put(4,new Customer(4,"Duong D","duongd@gmail.com","Quang Tri"));
        customerMap.put(5,new Customer(5,"Duong E","duonge@gmail.com","Quang Binh"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public void save(Customer customer) {
        customerMap.put(customer.getCode(),customer);
    }

    @Override
    public Customer findId(int id) {
        return customerMap.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customerMap.put(id,customer);
    }

    @Override
    public void remove(int id) {
        customerMap.remove(id);
    }
}
