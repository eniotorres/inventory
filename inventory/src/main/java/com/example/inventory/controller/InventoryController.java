package com.example.inventory.controller;

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

import com.example.inventory.repository.IInventoryRepository;
import com.example.inventory.entity.Inventory;

@RestController
@RequestMapping("/api/inventories")
public class InventoryController {
	

	 @Autowired
	 private IInventoryRepository inventoryRepository;
	 
	 @GetMapping
	 	public List < Inventory > getInventories() {
	        return (List<Inventory>) this.inventoryRepository.findAll();
	    }
	 
	 @GetMapping("/{id}")
	    public Inventory getInventoryById(@PathVariable(value = "id") long id) {
	        return this.inventoryRepository.findById(id).get();
	    }
	 
	 //insert
	 @PostMapping
	    public Inventory createInventory(@RequestBody Inventory i) {
	        return this.inventoryRepository.save(i);
	        
	    }
	 
	 // update
	 @PutMapping("/{id}")
	    public Inventory updateInventory(@RequestBody Inventory i, @PathVariable("id") long id) {
	    	Inventory inventory = this.inventoryRepository.findById(id).get();
	    	inventory.setProductId(i.getProductId());
	    	inventory.setAvailable(i.getAvailable());
	        return this.inventoryRepository.save(inventory);
	    }
 
	 @DeleteMapping("/{id}")
	 public ResponseEntity < Inventory > deleteInventory(@PathVariable("id") long id) {
	 	Inventory i = this.inventoryRepository.findById(id).get();
	     this.inventoryRepository.delete(i);
	     return ResponseEntity.ok().build();
	 }

}
