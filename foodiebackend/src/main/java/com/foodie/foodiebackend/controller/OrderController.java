package com.foodie.foodiebackend.controller;

import com.foodie.foodiebackend.model.Order;
import com.foodie.foodiebackend.repository.OrderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "http://localhost:4200")  // Allows frontend requests
public class OrderController {
    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // ✅ 1. Create a new order
    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    // ✅ 2. Get all orders
    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // ✅ 3. Get an order by ID
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // ✅ 4. Update an existing order
    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order updatedOrder) {
        return orderRepository.findById(id).map(order -> {
            order.setCustomerName(updatedOrder.getCustomerName());
            order.setStatus(updatedOrder.getStatus());
            order.setItems(updatedOrder.getItems());
            return ResponseEntity.ok(orderRepository.save(order));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // ✅ 5. Delete an order
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return ResponseEntity.ok("Order deleted successfully!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
