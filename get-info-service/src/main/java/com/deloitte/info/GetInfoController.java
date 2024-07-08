package com.deloitte.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.info.dto.DishInfo;
import com.deloitte.info.services.GetInfoService;

@RestController
public class GetInfoController {

	@Autowired
	private GetInfoService getInfoService;
	
	@GetMapping("/get-dish-info/{dishId}")
	public DishInfo getDishInfobyDishId(@PathVariable("dishId") int dishId) {
		
		DishInfo dishInfo = getInfoService.getDishInfobyDishId(dishId);
		return dishInfo;
	}
	
	@GetMapping("get-dish-info-restTemplate/{dishId}")
	public DishInfo getDishInfoById_restTemplate(@PathVariable("dishId") int dishId) {
		
		DishInfo dishInfo = getInfoService.getDishInfoById_restTemplate(dishId);
		return dishInfo;
	}
	
	@GetMapping("get-dish-info-webClient/{dishId}")
	public DishInfo getDishInfoById_webClient(@PathVariable("dishId") int dishId) {
		
		DishInfo dishInfo = getInfoService.getDishInfoById_webClient(dishId);
		return dishInfo;
	}
}
