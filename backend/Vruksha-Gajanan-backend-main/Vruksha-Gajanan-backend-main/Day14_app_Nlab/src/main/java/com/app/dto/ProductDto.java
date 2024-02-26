package com.app.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDto {
	
//	@JsonProperty(access = Access.READ_ONLY) // used during serialization
//	private Long id;
	
	private String pName;
	
	private double pPrice;
	
	private boolean pStock;
	
	private int pQuantity;
	
	private String pImage;
	
	private String pDescription;
	
	

}
