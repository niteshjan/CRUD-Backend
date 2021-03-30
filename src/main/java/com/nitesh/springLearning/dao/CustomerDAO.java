package com.nitesh.springLearning.dao;

import com.nitesh.springLearning.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDAO extends CrudRepository<Customer, Integer> {
    @Override
    List<Customer> findAll();   //override findall method to return list instead of Iterable
}
