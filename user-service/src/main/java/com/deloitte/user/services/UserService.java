package com.deloitte.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.user.dto.UserDto;
import com.deloitte.user.entity.Address;
import com.deloitte.user.entity.User;
import com.deloitte.user.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;

	public void saveUser(UserDto userDto) {

		User user=new User();
		user.setUserName(userDto.getUserName());
		
		Address address=new Address();
		address.setAddress(userDto.getAddressDto().getAddress());
		
		user.setUserAddress(address);
		
		userRepo.save(user);
	}
	

	public User getUser(int userId) throws Exception {
		
		User user=userRepo.findById(userId).orElseThrow(() -> new Exception("user not found with Id- " + userId));
		
		return user;
	}


	public void updateUser(UserDto userDto, int userId) throws Exception {
		
		User user=userRepo.findById(userId).orElseThrow(() -> new Exception("user not found with Id- " +userId));
		
		user.setUserName(userDto.getUserName());
		
		Address address=user.getUserAddress();
		address.setAddress(userDto.getAddressDto().getAddress());
		
		user.setUserAddress(address);
		
		userRepo.save(user);
	}

	public void deleteUser(int userId) {

		userRepo.deleteById(userId);
	}

}
