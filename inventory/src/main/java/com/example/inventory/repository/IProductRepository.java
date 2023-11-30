package com.example.inventory.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.inventory.entity.Product;

public interface IProductRepository extends CrudRepository<Product, Long>{

}
