package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.productDao;
import com.app.dto.ApiResponse;
import com.app.dto.ProductDto;
import com.app.dto.ProductResponse;
import com.app.entities.Product;

@Service
@Transactional
public class ProductImpl implements ProductService {

	@Autowired
	private productDao pdao;
	
	@Autowired
	private ModelMapper mm;

	@Override
	public ProductDto addNewProduct(ProductDto pdto) {
		Product p1 = mm.map(pdto, Product.class);
		Product savedProduct =pdao.save(p1);
		System.out.println("p entity id " + p1.getId() + " " + savedProduct.getId());
		return mm.map(savedProduct, ProductDto.class);			
	
	}

	@Override
	public ProductResponse getAllProducts(int pageNumber,int pageSize,String sortBy,String sortDir) {
		
		Sort sort=null;
		if(sortDir.trim().toLowerCase().equals("asc")) {
			sort=sort.by(sortBy).ascending();
		}
		else{
			sort=Sort.by(sortBy).descending();
			System.out.println(sort);
			
		}
		
		Pageable pageable=PageRequest.of(pageNumber, pageSize, sort);
		Page<Product> page=this.pdao.findAll(pageable);
		List<Product> pageProduct=page.getContent();
		
		List<ProductDto> pageProductDto = pageProduct.stream()
					.map((s)->mm.map(s,ProductDto.class))
				.collect(Collectors.toList());
		
		ProductResponse response=new ProductResponse();
		response.setContent(pageProductDto);
		response.setPageNumber(page.getNumber());
		response.setPageSize(page.getSize());
		response.setTotalPages(page.getTotalPages());
		response.setLastPage(page.isLast());
		
		
		return response;
		
		
//		return pdao.findAll()
//				.stream()
//				.map((s)->mm.map(s,ProductDto.class))
//				.collect(Collectors.toList());

	}

	@Override
	public ProductDto getById(Long id) {
		Product p1 = pdao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid product ID(no sunch product with given id!!!  with id = " +id));
		
		return mm.map(p1, ProductDto.class);
	
	}

	@Override
	public ApiResponse deleteProduct(Long Id) {
		Product p1 = pdao.findById(Id).
				orElseThrow(() -> new ResourceNotFoundException("Invalid id(no product found with given id)"));

		// Before deleting emp rec , delete it's child rec from ProjectEmpDetails
		pdao.deleteById(Id);// yet to be tested
		pdao.delete(p1);// yet to be tested
		return new ApiResponse("Product Details of product with ID " + p1.getId() + " deleted....");
	
	}

	//update
	@Override
	public ProductDto updateProduct(Long Id, ProductDto newpdto) {
		Product oldp1 = pdao.findById(Id)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid product ID , product not found !!!!"));
		System.out.println(newpdto);	
		oldp1.setPImage(newpdto.getPImage());
		oldp1.setPDescription(newpdto.getPDescription());
		oldp1.setPName(newpdto.getPName());
		oldp1.setPPrice(newpdto.getPPrice());
		oldp1.setPQuantity(newpdto.getPQuantity());
		oldp1.setPStock(newpdto.isPStock());
		
		Product save=pdao.save(oldp1);
		
		mm.map(newpdto, save);
			System.out.println("after mapping " + save);		
			return newpdto;
		}
	
	
	
}
