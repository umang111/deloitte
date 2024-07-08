package com.deloitte.dish.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "ratings")
public class Ratings {

	@Id
	@GeneratedValue
	@Column(name = "rating_Id")
	private int ratingId;
	
	@Column(name = "rating")
	private int rating;
	
	@Column(name = "user_Id", unique = true)
	private int userId;

}
