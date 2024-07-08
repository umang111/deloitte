package com.deloitte.dish.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deloitte.dish.entity.Dish;

public interface DishRepo extends JpaRepository<Dish, Integer>{

}
