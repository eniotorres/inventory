package com.example.inventory.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.inventory.entity.Order;

public interface IOrderRepository extends CrudRepository<Order, Long>{

}
