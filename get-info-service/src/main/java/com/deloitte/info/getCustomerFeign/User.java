package com.deloitte.info.getCustomerFeign;



import lombok.Data;

@Data
public class User {

	private int userId;
	
	private String userName;
	
	private Address userAddress;
	
}
