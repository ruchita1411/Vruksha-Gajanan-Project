package com.app.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cart")
@Getter
@Setter

public class CartItem extends BaseEntity{
	
	private int quantity;
	
	private double totalPrice;
	
	@ManyToOne
	private Carts cart;
	
	@OneToOne
	private Product product;

}
