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

import com.example.inventory.entity.OrderDetail;
import com.example.inventory.repository.IDetailRepository;

@RestController
@RequestMapping("/api/details")
public class DetailController {
	
	@Autowired
	private IDetailRepository detailRepository;
	
	@GetMapping
 	public List < OrderDetail > getdetails() {
        return (List<OrderDetail>) this.detailRepository.findAll();
    }
 
 @GetMapping("/{id}")
    public OrderDetail getDetailById(@PathVariable(value = "id") long id) {
        return this.detailRepository.findById(id).get();
    }
 
 //insert
 @PostMapping
    public OrderDetail createDetail(@RequestBody OrderDetail o) {
        return this.detailRepository.save(o);
        
    }
 
 // update
 @PutMapping("/{id}")
    public OrderDetail updateInventory(@RequestBody OrderDetail o, @PathVariable("id") long id) {
	 OrderDetail orderDetail = this.detailRepository.findById(id).get();
	 orderDetail.setProduct(o.getProduct());
	 orderDetail.setOrder(o.getOrder());
	 orderDetail.setQty(o.getQty());
        return this.detailRepository.save(orderDetail);
    }

 @DeleteMapping("/{id}")
 public ResponseEntity < OrderDetail > deleteDetail(@PathVariable("id") long id) {
	 OrderDetail o = this.detailRepository.findById(id).get();
     this.detailRepository.delete(o);
     return ResponseEntity.ok().build();
 }

}
