package com.invoice.springbootresptapiexample.repository;

import com.invoice.springbootresptapiexample.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
