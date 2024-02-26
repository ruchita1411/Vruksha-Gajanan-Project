package com.app.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AppConstants;
import com.app.dto.ProductDto;
import com.app.service.ProductService;
import com.app.entities.*;
@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:3000")

public class ProductController {
	
	@Autowired
	private ProductService pService;

	//create
	@PostMapping("/create")
	public ResponseEntity<?> addNewProduct(@RequestBody @Valid ProductDto pdto) {
		System.out.println("in add product " + pdto);
		return ResponseEntity.status(HttpStatus.CREATED).body(pService.addNewProduct(pdto));
	}
	
	
	//getall
	
	@GetMapping("/get")
	public ResponseEntity<?>  getList(@RequestParam(value="pageNumber",defaultValue=AppConstants.PAGE_NUMBER_STRING,required=false) int pageNumber,
			@RequestParam(value="pageSize",defaultValue=AppConstants.PAGE_SIZE_STRING,required=false) int pageSize,
			@RequestParam(value="sortBy" ,defaultValue=AppConstants.SORT_By_STRING,required=false) String sortBy,
			@RequestParam(value="sortDir",defaultValue = AppConstants.SORT_DIR_STRING,required = false) String sortDir){
		System.out.println("get products");
		return ResponseEntity.ok(pService.getAllProducts(pageNumber,pageSize,sortBy,sortDir));
	}
	
	
	//getby id
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<?> getEntity(@PathVariable Long id){
		System.out.println("in get by id"+id);
		return ResponseEntity.ok(pService.getById(id));
	}

	
	//delete
	@DeleteMapping("/{Id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long Id) {
		System.out.println("in delete product " + Id);
		return ResponseEntity.ok(pService.deleteProduct(Id));
	}
	
	//update
	
	@PutMapping("/update/{Id}")
	public ResponseEntity<?> updateProduct(@PathVariable Long Id, @RequestBody @Valid ProductDto dto) {
		System.out.println("in update product " + Id + " " + dto);
		return ResponseEntity.ok(pService.updateProduct(Id, dto));
	}
	
}
