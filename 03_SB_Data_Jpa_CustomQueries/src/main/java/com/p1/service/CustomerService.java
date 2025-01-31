package com.p1.service;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.p1.entity.Customer;
import com.p1.repo.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getCustomersByName(String name) {
        return customerRepository.findByName(name);
    }

    public List<Customer> getCustomersByCity(String city) {
        return customerRepository.findByCity(city);
    }

    public List<Customer> getCustomersOlderThan(int age) {
        return customerRepository.findByAgeGreaterThan(age);
    }

    public List<Customer> searchByEmail(String keyword) {
        return customerRepository.findByEmailContaining(keyword);
    }

    public List<Customer> getTop5OldestCustomers() {
        Pageable pageable = PageRequest.of(0, 5);
        return customerRepository.findTop5OldestCustomers(pageable);
    }

    public int updateEmail(Long id, String newEmail) {
        return customerRepository.updateCustomerEmail(id, newEmail);
    }

    public int deleteCustomersInCity(String city) {
        return customerRepository.deleteCustomersByCity(city);
    }
}

