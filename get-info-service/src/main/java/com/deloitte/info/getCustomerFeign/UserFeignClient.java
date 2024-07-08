package com.deloitte.info.getCustomerFeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="user-service" , url = "http://localhost:8081")

@FeignClient(name="user-service")
public interface UserFeignClient {

	@GetMapping("/getuser/{userId}")
	public User getUser(@PathVariable("userId") Integer userId);
	
}
