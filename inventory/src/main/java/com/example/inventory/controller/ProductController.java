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

import com.example.inventory.entity.Product;
import com.example.inventory.repository.IProductRepository;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
		
		 @Autowired
		 private IProductRepository productRepository;
		 
		 @GetMapping
		 	public List < Product > getProducts() {
		        return (List<Product>) this.productRepository.findAll();
		    }
		 
		 @GetMapping("/{id}")
		    public Product getProductById(@PathVariable(value = "id") long id) {
		        return this.productRepository.findById(id).get();
		    }
		 
		 //insert
		 @PostMapping
		    public Product createProduct(@RequestBody Product c) {
		        return this.productRepository.save(c);
		        
		    }
		 
	    // update
	    @PutMapping("/{id}")
		    public Product updateProduct(@RequestBody Product p, @PathVariable("id") long id) {
		    	Product Product = this.productRepository.findById(id).get();
		    	Product.setDescription(p.getDescription());
		    	Product.setPrice(p.getPrice());
		        return this.productRepository.save(Product);
		    }
	    
	    @DeleteMapping("/{id}")
	    public ResponseEntity < Product > deleteProduct(@PathVariable("id") long id) {
	    	Product p = this.productRepository.findById(id).get();
	        this.productRepository.delete(p);
	        return ResponseEntity.ok().build();
	    }


}
