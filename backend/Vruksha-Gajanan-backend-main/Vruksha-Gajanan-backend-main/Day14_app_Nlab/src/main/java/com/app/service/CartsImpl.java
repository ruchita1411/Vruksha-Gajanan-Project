package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Carts;

@Service
@Transactional

public class CartsImpl implements CartService {
	
	@Autowired
	private Carts carts;
	
	@Autowired
	private ModelMapper mm;
	
	
	
	
}
