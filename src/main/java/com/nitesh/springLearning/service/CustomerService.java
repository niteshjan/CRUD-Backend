package com.nitesh.springLearning.service;

import com.nitesh.springLearning.model.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
@Component
public class CustomerService {
    private int customerCount = 0;
    private List<Customer> customerList =  new CopyOnWriteArrayList<>();
    public Customer addCustomer(Customer customer){
        customerCount++;
        customer.setCustomerId(customerCount);
        customerList.add(customer);
        return customer;
    }
    public List<Customer> getCustomers(){
        return customerList;
    }
    public Customer getCustomer(int customerId){
        return customerList
                .stream()
                .filter(c -> c.getCustomerId() == customerId)
                .findFirst()
                .get();
    }
    public Customer updateCustomer(int customerId, Customer customer){
        customerList
                .stream()
                .forEach(c -> {
                    if(c.getCustomerId() == customerId){
                        c.setCustomerEmail(customer.getCustomerEmail());
                        c.setCustomerName(customer.getCustomerName());
                    }
                });
        return customerList
                .stream()
                .filter(c -> c.getCustomerId() == customerId)
                .findFirst()
                .get();
    }
    public void deleteCustomer(int customerId){
        customerList
                .stream()
                .forEach(c ->{
                    if(c.getCustomerId() == customerId){
                        customerList.remove(c);
                    }
                });
    }

}
