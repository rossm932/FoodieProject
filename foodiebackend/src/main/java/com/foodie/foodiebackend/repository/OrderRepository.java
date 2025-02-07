package com.foodie.foodiebackend.repository;

import com.foodie.foodiebackend.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // Custom query methods (if needed) can be added here
}
