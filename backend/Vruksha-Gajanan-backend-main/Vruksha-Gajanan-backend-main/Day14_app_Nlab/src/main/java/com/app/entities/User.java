package com.app.entities;

import java.util.Collection;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

@Entity
@Table(name = "user")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@FieldNameConstants
public class User extends BaseEntity {
	
	@Column(length = 30,nullable=false)
	private String name;
	
	@Column(length = 30, unique = true) 
	private String email;
	
	@Column(nullable = false) // =>NOT NULL
	private String password;
	
	private String address;
	
	@Column(length = 10)
	private String phone;
	
	@ManyToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL )
	Set<Roles> role=new HashSet<>();

	@OneToOne(mappedBy ="user")
	private Carts cart;
	
	
}
