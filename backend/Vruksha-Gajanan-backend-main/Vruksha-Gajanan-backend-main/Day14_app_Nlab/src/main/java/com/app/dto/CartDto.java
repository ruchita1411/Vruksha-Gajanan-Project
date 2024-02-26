package com.app.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.app.entities.CartItem;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CartDto {
	
	
	private Set<CartItemDto> items =new HashSet<CartItemDto>();
	
	
	private UserDto user;

}
