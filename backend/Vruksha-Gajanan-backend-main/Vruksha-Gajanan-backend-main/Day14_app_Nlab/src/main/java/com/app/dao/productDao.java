package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Product;

public interface productDao extends JpaRepository<Product, Long> {

	public Product findById(int product);
}
