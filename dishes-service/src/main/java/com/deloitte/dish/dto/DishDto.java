package com.deloitte.dish.dto;

import java.util.List;

import lombok.Data;

@Data
public class DishDto {
	
	private String dishName;
	
	private String description;
	
	private List<RatingDto> ratingDto;
}
