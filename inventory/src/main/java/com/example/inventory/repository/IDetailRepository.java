package com.example.inventory.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.inventory.entity.OrderDetail;

public interface IDetailRepository extends CrudRepository<OrderDetail, Long>{

}
