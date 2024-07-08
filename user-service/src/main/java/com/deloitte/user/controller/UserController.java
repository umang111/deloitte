package com.deloitte.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.user.dto.UserDto;
import com.deloitte.user.entity.User;
import com.deloitte.user.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/saveUser")
	public void saveUser(@RequestBody UserDto user) {
		
		userService.saveUser(user);
	}
	
	@GetMapping("/getuser/{userId}")
	public User getUser(@PathVariable("userId") int userId) throws Exception {
		
		User user=userService.getUser(userId);
		return user;
	}
	
	@PutMapping("/updateUser/{userId}")
	public void updateUser(@RequestBody UserDto userDto, @PathVariable("userId") int userId) throws Exception {
		
		userService.updateUser(userDto,userId);
	}
	
	@DeleteMapping("/deleteUser/{userId}")
	public void deleteUser(@PathVariable("userId") int userId) {
		
		userService.deleteUser(userId);
	}
}

















