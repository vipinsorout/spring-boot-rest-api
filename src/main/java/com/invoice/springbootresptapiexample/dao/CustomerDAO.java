package com.invoice.springbootresptapiexample.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invoice.springbootresptapiexample.model.Customer;
import com.invoice.springbootresptapiexample.repository.CustomerRepository;

@Service
public class CustomerDAO {

	@Autowired
	CustomerRepository customerRepository;
	
	/* Save */
	public Customer save(Customer cus) {
		return customerRepository.save(cus);
	}
	
	public List<Customer> getAll(){
		return customerRepository.findAll();
	}
	
	public Customer getById(Long id) {
		return customerRepository.findById(id).get();
	}
	
	public void deleteById(Long id) {
		customerRepository.deleteById(id);
	}

 }
