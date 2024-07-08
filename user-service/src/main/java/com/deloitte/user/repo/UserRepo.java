package com.deloitte.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deloitte.user.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
