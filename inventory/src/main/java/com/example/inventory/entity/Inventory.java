package com.example.inventory.entity;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="inventories")
public class Inventory implements Serializable{
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "id_product")
	private Long productId;
	
	private int available;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
