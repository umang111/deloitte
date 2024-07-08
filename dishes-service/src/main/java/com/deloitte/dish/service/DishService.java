package com.deloitte.dish.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.dish.dto.DishDto;
import com.deloitte.dish.dto.RatingDto;
import com.deloitte.dish.entity.Dish;
import com.deloitte.dish.entity.Ratings;
import com.deloitte.dish.repo.DishRepo;

@Service
public class DishService {
	
	@Autowired
	private DishRepo dishRepo;

	public void saveDish(DishDto dishDto) {
		
		Dish dish = new Dish();
		dish.setDishName(dishDto.getDishName());
		dish.setDescription(dishDto.getDescription());
		
		List<RatingDto> ratingDtos = dishDto.getRatingDto();
		List<Ratings> ratings = ratingDtos.stream().map(oneRating -> convertRatingDtoToEntity(oneRating))
				.collect(Collectors.toList());
		
		dish.setRatings(ratings);
		dishRepo.save(dish);
		
	}

	private Ratings convertRatingDtoToEntity(RatingDto oneRating) {
		
		Ratings rating = new Ratings();
		rating.setRating(oneRating.getRating());
		rating.setUserId(oneRating.getUserId());
		
		return rating;
	}

	public void addRatingInExistingDish(int dishId, RatingDto ratingDto) throws Exception{
		
		Dish dish = dishRepo.findById(dishId).orElseThrow(() -> new Exception("Dish Not Found with Id" + dishId));
		
		Ratings rating=convertRatingDtoToEntity(ratingDto);
		dish.getRatings().add(rating);
		dishRepo.save(dish);
		
	}

	public Dish getDishById(int dishId) throws Exception {
		
		Dish dish = dishRepo.findById(dishId).orElseThrow(() -> new Exception("Dish Not Found with Id" + dishId));

		return dish;
	}

}


















