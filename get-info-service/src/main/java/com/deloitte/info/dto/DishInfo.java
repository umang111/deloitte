package com.deloitte.info.dto;

import java.util.List;

import lombok.Data;

@Data
public class DishInfo {

	private String dishName;
	private List<DishRating> dishRatings;
	
}
