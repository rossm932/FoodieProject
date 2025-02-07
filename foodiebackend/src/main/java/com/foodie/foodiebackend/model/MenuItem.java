package com.foodie.foodiebackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "menu_items")  // ✅ Matches your database table name
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // ✅ Now included in JSON response

    private String name;
    private double price;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)  // ✅ Links menu item to restaurant
    @JsonIgnoreProperties("menuItems")  // ✅ Prevents infinite recursion in JSON response
    private Restaurant restaurant;

    // ✅ Constructors
    public MenuItem() {}

    public MenuItem(Long id, String name, double price, Restaurant restaurant) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.restaurant = restaurant;
    }

    // ✅ Getters & Setters
    public Long getId() { return id; }  // ✅ Ensures ID appears in JSON response
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public Restaurant getRestaurant() { return restaurant; }
    public void setRestaurant(Restaurant restaurant) { this.restaurant = restaurant; }

    // ✅ Useful for debugging/logging
    @Override
    public String toString() {
        return "MenuItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", restaurant=" + (restaurant != null ? restaurant.getId() : "null") +
                '}';
    }
}

