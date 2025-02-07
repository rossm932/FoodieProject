package com.foodie.foodiebackend.repository;

import com.foodie.foodiebackend.model.MenuItem;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> { 
	List<MenuItem> findByRestaurantId(Long restaurantId);

}
