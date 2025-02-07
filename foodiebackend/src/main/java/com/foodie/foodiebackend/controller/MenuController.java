package com.foodie.foodiebackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodie.foodiebackend.model.MenuItem;
import com.foodie.foodiebackend.model.Restaurant;
import com.foodie.foodiebackend.repository.MenuItemRepository;
import com.foodie.foodiebackend.repository.RestaurantRepository;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    // ✅ Get all menu items for a specific restaurant
    @GetMapping("/{restaurantId}")
    public List<MenuItem> getMenuByRestaurant(@PathVariable Long restaurantId) {
        return menuItemRepository.findByRestaurantId(restaurantId);  // ✅ Ensure this method exists in repository
    }

    @PostMapping("/{restaurantId}")
    public MenuItem addDish(@PathVariable Long restaurantId, @RequestBody MenuItem menuItem) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
            .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        menuItem.setRestaurant(restaurant); // ✅ Set restaurant before saving
        return menuItemRepository.save(menuItem);
    }
}
