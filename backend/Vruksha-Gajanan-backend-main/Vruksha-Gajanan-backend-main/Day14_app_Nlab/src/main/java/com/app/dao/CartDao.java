package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Carts;

public interface CartDao extends JpaRepository<Carts, Long> {

}
