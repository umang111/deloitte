package com.deloitte.info.RatingFeignCLient;

import java.util.List;

import lombok.Data;

@Data
public class Dish {

	
	private int dishId;

	private String dishName;

	private String description;
	
	private List<Ratings> ratings;

}
