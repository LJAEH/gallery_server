package org.ljaeh.boook.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "carts")
@SequenceGenerator(
		name = "CART_SEQ_GENERATOR" , sequenceName = "CART_SEQ" ,
		initialValue = 1, allocationSize = 1
)
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
			generator = "CART_SEQ_GENERATOR")
	private int id;
	
	@Column( length = 100, nullable = false)
	private int memberId;
	
	@Column( length = 100, nullable = false)
	private int itemId;
	

	
}
