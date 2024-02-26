package com.app.dto;

import java.util.List;

import com.app.entities.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {
	
	private List<ProductDto> content;
	
	private int pageNumber;
	
	private int pageSize;
	
	private int totalPages;
	
	private Boolean lastPage;
	
	
	

}
