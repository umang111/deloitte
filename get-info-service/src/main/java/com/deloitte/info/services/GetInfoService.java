package com.deloitte.info.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.deloitte.info.RatingFeignCLient.Dish;
import com.deloitte.info.RatingFeignCLient.DishFeignClient;
import com.deloitte.info.RatingFeignCLient.Ratings;
import com.deloitte.info.dto.DishInfo;
import com.deloitte.info.dto.DishRating;
import com.deloitte.info.getCustomerFeign.User;
import com.deloitte.info.getCustomerFeign.UserFeignClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class GetInfoService {
	
	@Autowired
	private DishFeignClient dishFeignClient;
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	public WebClient.Builder webClientBuilder;
	

//	@CircuitBreaker(name = "getDishInfobyDishIdBreaker", fallbackMethod = "getDishInfobyDishIdFallBackMethod")
	public DishInfo getDishInfobyDishId(int dishId) {
		DishInfo dishInfo = new DishInfo();
		
		Dish getDish = dishFeignClient.getDishById(dishId);
		dishInfo.setDishName(getDish.getDishName());
		
		List<DishRating> dishRatings = getDish.getRatings().stream().map(rating-> setDishRatingDto(rating))
				.collect(Collectors.toList());
		
		dishInfo.setDishRatings(dishRatings);
		
		return dishInfo;
	}

	
	public DishRating setDishRatingDto(Ratings rating) {
		
		DishRating dishRating = new DishRating();
		
		User user = userFeignClient.getUser(rating.getUserId());

		dishRating.setDishRating(rating.getRating());
		dishRating.setUsername(user.getUserName());	
		
		return dishRating;
	}
	
//	public DishInfo getDishInfobyDishIdFallBackMethod(Ratings rating) {
//		
//		DishInfo dishInfo = new DishInfo();
//		dishInfo.setDishName("circuit breake");
//		
//		List<DishRating> dishRatings = new ArrayList<>();
//		
//		DishRating dishRating = new DishRating();
//		dishRating.setDishRating(2);
//		dishRating.setUsername("circuit breake");	
//		
//		dishRatings.add(dishRating);
//		
//		dishInfo.setDishRatings(dishRatings);
//		
//		return dishInfo;
//	}
	
	
//	achieve same functionality using rest template 
	
	public DishInfo getDishInfoById_restTemplate(int dishId) {
		
		DishInfo dishInfo = new DishInfo();
		
		Dish getDish = restTemplate.getForObject("http://localhost:8082/getDishById/" + dishId, Dish.class);
		
        dishInfo.setDishName(getDish.getDishName());
		
		List<DishRating> dishRatings = getDish.getRatings().stream().map(rating-> setDishRatingDto_restTemplate(rating))
				.collect(Collectors.toList());
		
		dishInfo.setDishRatings(dishRatings);
		
		return dishInfo;
		
	}

	private DishRating setDishRatingDto_restTemplate(Ratings rating) {
		
        DishRating dishRating = new DishRating();
		
		User user = restTemplate.getForObject("http://localhost:8081/getuser/" +rating.getUserId() , User.class);
		dishRating.setDishRating(rating.getRating());
		dishRating.setUsername(user.getUserName());	
		
		return dishRating;
	}

	
	
	//Achieve same functionality using WebClient ----------
	
	public DishInfo getDishInfoById_webClient(int dishId) {
		
		DishInfo dishInfo = new DishInfo();
		
//		Dish getDish = restTemplate.getForObject("http://localhost:8082/getDishById/" + dishId, Dish.class);
		
		Dish getDish = webClientBuilder.build()
				.get()
				.uri("http://localhost:8082/getDishById/" + dishId, Dish.class)
				.retrieve()
				.bodyToMono(Dish.class)
				.block();
		
        dishInfo.setDishName(getDish.getDishName());
		
		List<DishRating> dishRatings = getDish.getRatings().stream().map(rating-> setDishRatingDto_webClient(rating))
				.collect(Collectors.toList());
		
		dishInfo.setDishRatings(dishRatings);
		
		return dishInfo;
		
	}

	private DishRating setDishRatingDto_webClient(Ratings rating) {
		
        DishRating dishRating = new DishRating();
		
		User user = webClientBuilder.build()
				.get()
				.uri("http://localhost:8081/getuser/" +rating.getUserId() , User.class)
				.retrieve()
				.bodyToMono(User.class)
				.block();
		
		dishRating.setDishRating(rating.getRating());
		dishRating.setUsername(user.getUserName());	
		
		return dishRating;
	}
	
	
	

}























