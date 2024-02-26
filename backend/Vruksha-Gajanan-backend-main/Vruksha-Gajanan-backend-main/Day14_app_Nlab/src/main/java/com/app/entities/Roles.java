package com.app.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Roles extends BaseEntity{
	
	@Column(name="Role_Name",nullable=false)
	private String roleName;
	
	@ManyToMany(mappedBy="role")
	Set<User> user=new HashSet<>();
	
	
	

}
