package com.deloitte.dish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.dish.dto.DishDto;
import com.deloitte.dish.dto.RatingDto;
import com.deloitte.dish.entity.Dish;
import com.deloitte.dish.service.DishService;

@RestController
public class DishController {

	@Autowired
	private DishService dishService;
	
	@PostMapping("/saveDish")
	public void saveDish(@RequestBody DishDto dishDto) {
		dishService.saveDish(dishDto);
	}
	
	@PostMapping("/add-rating/{dishId}")
	public void addRatingInExistingDish(@PathVariable("dishId") int dishId, @RequestBody RatingDto ratingDto) throws Exception {
		
		dishService.addRatingInExistingDish(dishId,ratingDto);

	}
	
	@GetMapping("/getDishById/{dishId}")
	public Dish getDishById(@PathVariable("dishId") int dishId) throws Exception {
		
		Dish dish =dishService.getDishById(dishId);
		
		return dish;
	}
}
