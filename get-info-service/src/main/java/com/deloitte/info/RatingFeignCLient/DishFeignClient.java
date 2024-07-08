package com.deloitte.info.RatingFeignCLient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//@FeignClient(name = "rating-service", url = "http://localhost:8082")
@FeignClient(name = "dishes-service")
public interface DishFeignClient {

	@GetMapping("/getDishById/{dishId}")
	public Dish getDishById(@PathVariable("dishId") int dishId);
}
