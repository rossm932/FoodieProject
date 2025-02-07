package com.foodie.foodiebackend.repository;

import com.foodie.foodiebackend.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
	
}
