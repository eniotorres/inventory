package com.example.inventory.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.inventory.entity.Customer;

public interface ICustomerRepository extends CrudRepository<Customer, Long>{

}
