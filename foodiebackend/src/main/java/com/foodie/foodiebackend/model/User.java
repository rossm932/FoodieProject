package com.foodie.foodiebackend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter  // Lombok generates all getter methods
@Setter  // Lombok generates all setter methods
@NoArgsConstructor  // Default constructor
@AllArgsConstructor  // Constructor with all fields
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password;
    private String role;
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
