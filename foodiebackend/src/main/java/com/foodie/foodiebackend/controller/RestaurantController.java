package com.foodie.foodiebackend.controller;

import com.foodie.foodiebackend.model.Restaurant;
import com.foodie.foodiebackend.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200") // Temporary test
@RestController
@RequestMapping("/api/restaurants")  // Matches Postman URL
public class RestaurantController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    // POST Endpoint for Adding a Restaurant
    @PostMapping
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    // GET Endpoint to Retrieve All Restaurants
    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }
}
