package com.example.inventory.controller;
import com.example.inventory.entity.Customer;

import java.util.List;

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

import com.example.inventory.repository.ICustomerRepository;


@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	
	 @Autowired
	 private ICustomerRepository customerRepository;
	 
	 @GetMapping
	 	public List < Customer > getCustomers() {
	        return (List<Customer>) this.customerRepository.findAll();
	    }
	 
	 @GetMapping("/{id}")
	    public Customer geCustomerById(@PathVariable(value = "id") long id) {
	        return this.customerRepository.findById(id).get();
	    }
	 
	 //insert
	 @PostMapping
	    public Customer createCustomer(@RequestBody Customer c) {
	        return this.customerRepository.save(c);
	        
	    }
	 
    // update
    @PutMapping("/{id}")
	    public Customer updateUser(@RequestBody Customer c, @PathVariable("id") long id) {
	    	Customer customer = this.customerRepository.findById(id).get();
	    	customer.setName(c.getName());
	    	customer.setStatus(c.getStatus());
	        return this.customerRepository.save(customer);
	    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity < Customer > deleteUser(@PathVariable("id") long id) {
    	Customer c = this.customerRepository.findById(id).get();
        this.customerRepository.delete(c);
        return ResponseEntity.ok().build();
    }


}
