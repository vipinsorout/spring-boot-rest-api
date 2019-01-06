package com.invoice.springbootresptapiexample.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invoice.springbootresptapiexample.dao.CustomerDAO;
import com.invoice.springbootresptapiexample.model.Customer;

@RestController
@RequestMapping("/company")
public class CustomerController {

	@Autowired
	CustomerDAO customerDao;
	
	@PostMapping("/cusomers")
	public Customer createCusomter(@Valid @RequestBody Customer cus) {
		return customerDao.save(cus);
	}
	
	/*get all customer*/
	@GetMapping(" /customers")
	public List<Customer> getAllCustomer(){
		return customerDao.getAll();
	}
	
	@GetMapping("/note/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable(value = "id") Long cusid) {
		Customer cus =  customerDao.getById(cusid);
		 if(cus == null) {
		return ResponseEntity.notFound().build();
		 }
		 
		 return ResponseEntity.ok().body(cus);
	}
	
	@PutMapping("/note/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") Long cusid,@Valid @RequestBody Customer cusDetails){
		Customer cus = customerDao.getById(cusid);
		if(cus == null) {
			return ResponseEntity.notFound().build();
		}
		
		cus.setName(cusDetails.getName());
		cus.setDesignation(cusDetails.getDesignation());
		cus.setExpertise(cusDetails.getExpertise());
		
		customerDao.save(cus);
		return ResponseEntity.ok().body(cus);
	}
	
	@DeleteMapping("/note/{id}")
	public ResponseEntity<Customer> delete(@PathVariable(value = "id") Long cusid){
		Customer cus = customerDao.getById(cusid);
		
		if(cus == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().build();
	}
}
