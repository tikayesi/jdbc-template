package com.enigma.gold.dao;

import com.enigma.gold.entity.Customer;
import com.enigma.gold.mapper.CustomerRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

//boleh menggunakan @Repository atau @Component yang penting keduanya mengubah class CustomerDaoImpl menjadi sebuah bean
@Component
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Customer findCustomerById(String id) {
        // tanda tanya berdasarkan urutan parameter
        String sql = "SELECT * FROM MST_CUSTOMER where id = ?";
        //ngasih tau jdbc template mappernya dan querynya
        // parameter id pada query object berdasarkan urutan pada parameter findcustomer dan urutan tanda tanyanya
        Customer customer = jdbcTemplate.queryForObject(sql, new CustomerRowMapper(), id);
        return customer;
    }


    @Override
    public List<Customer> findAllCustomer() {
        String sql = "SELECT * FROM mst_customer";
        List<Customer> customers = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Customer.class));
        return customers;
    }

    @Override
    public List<Customer> findAll() {
        String sql = "SELECT * FROM mst_customer";
        List<Customer> customers = jdbcTemplate.query(sql, new CustomerRowMapper());
        return customers;
    }

    @Override
    public List<Map<String, Object>> getAllCustomer() {
        String sql = "SELECT * FROM mst_customer";
        List<Map<String, Object>> customers = jdbcTemplate.queryForList(sql);
        return customers;
    }
}
