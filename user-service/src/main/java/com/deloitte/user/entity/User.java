package com.deloitte.user.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue
	private int userId;
	
	private String userName;
	
	@OneToOne(cascade = CascadeType.ALL) //using unidirectional mapping
	private Address userAddress;
	
	
	
}


