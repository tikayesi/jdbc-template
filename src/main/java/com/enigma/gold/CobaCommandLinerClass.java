package com.enigma.gold;

import com.enigma.gold.dao.CustomerDao;
import com.enigma.gold.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.List;
import java.util.Map;

@Component
public class CobaCommandLinerClass implements CommandLineRunner {

    @Autowired
    CustomerDao customerDao;

    @Override
    public void run(String... args) throws Exception {
        String id = "2";
        System.out.println("GET FROM DB WITH ID " + id);
        System.out.println("====================================");
        Customer customer = customerDao.findCustomerById(id);
        System.out.println(customer);
        System.out.println("====================================");
        System.out.println("FIND ALL CUSTOMERS by BEAN PROPERTY");
        List<Customer> custs = customerDao.findAllCustomer();
        System.out.println(custs);
        System.out.println("=====================================");
        System.out.println("FIND ALL CUST BY CUSTOM ROW MAPPER");
        List<Customer> customerList = customerDao.findAll();
        System.out.println(customerList);
        System.out.println("=====================================");
        System.out.println("GET ALL BY MAP Object");
        List<Map<String, Object>> customers = customerDao.getAllCustomer();
        System.out.println(customers);
        System.out.println("====================================");
        System.out.println("DONE");
    }
}
