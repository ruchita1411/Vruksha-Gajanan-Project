package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.ProductDto;
import com.app.dto.ProductResponse;

public interface ProductService {

	//create
	ProductDto addNewProduct(ProductDto pdto);

	//read
	ProductResponse getAllProducts(int pageNumber,int pageSize,String sortBy,String sortDir);

	//getby id
	ProductDto getById(Long id);
	
	//delete
	ApiResponse deleteProduct(Long Id);

	
	//update
	ProductDto updateProduct(Long Id, ProductDto pdto);


}
