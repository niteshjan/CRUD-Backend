package com.nitesh.springLearning.dao;

import com.nitesh.springLearning.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDAO extends CrudRepository<Customer, Integer> {

}
