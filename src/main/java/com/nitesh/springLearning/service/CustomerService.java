package com.nitesh.springLearning.service;

import com.nitesh.springLearning.dao.CustomerDAO;
import com.nitesh.springLearning.exception.CustomerNotFoundException;
import com.nitesh.springLearning.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
@Component
public class CustomerService {

    @Autowired
    private CustomerDAO customerDao;

    private int customerCount = 0;
    private List<Customer> customerList =  new CopyOnWriteArrayList<>();


    public Customer addCustomer(Customer customer){
        /*customerCount++;
        customer.setCustomerId(customerCount);
        customerList.add(customer);
        return customer;*/
        return customerDao.save(customer);
    }
    public List<Customer> getCustomers(){
        return customerDao.findAll();
        /*return customerList;*/
    }
    public Customer getCustomer(int customerId){
        /*return customerList
                .stream()
                .filter(c -> c.getCustomerId() == customerId)
                .findFirst()
                .get();*/
        Optional<Customer> optionalCustomer = customerDao.findById(customerId);
        if(optionalCustomer.isEmpty()){
            throw new CustomerNotFoundException("Customer Record not available");
        }
        return optionalCustomer.get();
    }
    public Customer updateCustomer(int customerId, Customer customer){
        /*customerList
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
                .get();*/
        customer.setCustomerId(customerId);
        return customerDao.save(customer);
    }
    public void deleteCustomer(int customerId){
        /*customerList
                .stream()
                .forEach(c ->{
                    if(c.getCustomerId() == customerId){
                        customerList.remove(c);
                    }
                });*/
        customerDao.deleteById(customerId);
    }

}
