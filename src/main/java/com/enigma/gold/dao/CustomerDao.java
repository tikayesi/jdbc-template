package com.enigma.gold.dao;

import com.enigma.gold.entity.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerDao {
    public Customer findCustomerById(String id);
    public List<Customer> findAllCustomer();
    public List<Customer> findAll();
    public List<Map<String, Object>> getAllCustomer();
}
