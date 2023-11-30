package com.example.inventory.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.inventory.entity.Inventory;

public interface IInventoryRepository  extends CrudRepository<Inventory, Long>{

}
