package com.example.inventory.controller;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

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

import com.example.inventory.entity.Order;
import com.example.inventory.repository.IOrderRepository;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
	
	 @Autowired
	 private IOrderRepository orderRepository;
	 
	 @GetMapping
	 	public List < Order > getOrders() {
	        return (List<Order>) this.orderRepository.findAll();
	    }
	 
	 @GetMapping("/{id}")
	    public Order getOrderyById(@PathVariable(value = "id") long id) {
	        return this.orderRepository.findById(id).get();
	    }
	 
	 //insert
	 @PostMapping
	    public Order createOrder(@RequestBody Order o) {
	        return this.orderRepository.save(o);
	        
	    }
	 
	 // update
	 @PutMapping("/{id}")
	    public Order updateInventory(@RequestBody Order o, @PathVariable("id") long id) {
	    	Order order = this.orderRepository.findById(id).get();
	    	order.setCustomerId(o.getCustomerId());
	    	order.setDate(o.getDate());
	    	order.setTotal(o.getTotal());
	        return this.orderRepository.save(order);
	    }

	 @DeleteMapping("/{id}")
	 public ResponseEntity < Order > deleteOrder(@PathVariable("id") long id) {
	 	Order o = this.orderRepository.findById(id).get();
	     this.orderRepository.delete(o);
	     return ResponseEntity.ok().build();
	 }

}
