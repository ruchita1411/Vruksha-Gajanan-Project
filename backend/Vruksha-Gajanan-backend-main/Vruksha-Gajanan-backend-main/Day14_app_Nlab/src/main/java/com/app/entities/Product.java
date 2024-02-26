package com.app.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "product")
@NoArgsConstructor
@Getter
@Setter
//@ToString(exclude = { "dept" }, callSuper = true)
public class Product extends BaseEntity {

	@Column(length = 30)
	private String pName;
	
	private double pPrice;
	
	private boolean pStock;
	
	private int pQuantity;
	
	private String pImage;
	
	private String pDescription;
	
	
}
