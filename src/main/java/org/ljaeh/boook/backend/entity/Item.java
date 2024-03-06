package org.ljaeh.boook.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "items")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column( length = 100, nullable = false)
	private String name;
	
	@Column( length = 100, nullable = false)
	private String imgPath;
	
	@Column( length = 100, nullable = false)
	private String price;
	
	@Column( length = 100, nullable = false)
	private String discountPer;
	

	
}
