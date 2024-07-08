package com.deloitte.dish.entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "dishes")
public class Dish {

	@Id
	@Column(name = "dish_id")
	private int dishId;
	
	@Column(name = "dish_name")
	private String dishName;
	
	@Column(name = "description")
	private String description;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "dish_id_fk")
	private List<Ratings> ratings;
	
	@PrePersist
	void setId() {
		dishId=Integer.parseInt(((UUID.randomUUID().toString()).replaceAll("[^1-9]", "")).substring(0,3));
	}
}
