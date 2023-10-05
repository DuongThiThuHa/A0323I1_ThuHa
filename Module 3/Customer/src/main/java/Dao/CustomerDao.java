package Dao;

import Model.Customer;

import java.util.HashMap;
import java.util.Map;

public class CustomerDao {
    private static final Map<Integer, Customer> listCustomer = new HashMap<Integer, Customer>();
    static {
        Customer customer1 = new Customer(1,"Dương Thu Hà", "011223344","thuha@gmail.com");
        Customer customer2 = new Customer(2,"Nguyễn Thu Hà", "055667788","thuha@gmail.com");
        Customer customer3 = new Customer(3,"Đỗ Thu Hà", "012121212","thuha@gmail.com");
        Customer customer4 = new Customer(4,"Phạm Thu Hà", "011221122","thuha@gmail.com");

    listCustomer.put(customer1.getCode(),customer1);
    listCustomer.put(customer2.getCode(),customer2);
    listCustomer.put(customer3.getCode(),customer3);
    listCustomer.put(customer4.getCode(),customer4);
    }

//    Viết phương thức xử lý get thông tin chi tiết  của 1 customer theo id
    public static Customer getListCustomer(int customerId) {
        return listCustomer.get(customerId);
    }
}
