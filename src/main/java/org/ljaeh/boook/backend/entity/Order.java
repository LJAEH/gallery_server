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
@Table(name = "orders")
@SequenceGenerator(
		name = "ORDER_SEQ_GENERATOR" , sequenceName = "ORDER_SEQ" ,
		initialValue = 1, allocationSize = 1
)
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
			generator = "ORDER_SEQ_GENERATOR")
	private int id;
	
	@Column( length = 100)
	private int memberId;
	
	@Column( length = 100, nullable = false)
	private String name;
	
	@Column( length = 500, nullable = false)
	private String address;
	
	@Column( length = 18, nullable = false)
	private String payment;
	
	@Column( length = 18)
	private String cardNumber;
	
	@Column( length = 500, nullable = false)
	private String items;
	
}
