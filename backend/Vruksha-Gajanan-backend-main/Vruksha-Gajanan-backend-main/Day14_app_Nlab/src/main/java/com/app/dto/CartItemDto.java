package com.app.dto;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.app.entities.Carts;
import com.app.entities.Product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class CartItemDto {
	
private int quantity;
	
	private double totalPrice;
	
	
	private CartDto cart;
	
	private ProductDto product;

}
