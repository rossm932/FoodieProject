package com.foodie.foodiebackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "menu_item_id", nullable = false) // Changed from dish_id to menu_item_id
    private MenuItem menuItem;  // Changed Dish to MenuItem

    private int quantity;

    public OrderItem() {}

    public OrderItem(Order order, MenuItem menuItem, int quantity) {
        this.order = order;
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public MenuItem getMenuItem() { // Updated getter
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) { // Updated setter
        this.menuItem = menuItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}