package com.example.storeproject.models.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Schema(description = "Represents users")
@Table(name ="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id",nullable = true)
    @Schema(description = "ID of the user",example = "1234")
    private long userId;

    @Column(name = "first_name",nullable = false)
    @Schema(description = "Name of user", example = "John Doe")
    private String userName;

    @Column(name = "email",nullable = false)
    @Schema(description = "Email of the user", example = "john.doe@example.com")
    private String email;

    @Column(name="password",nullable = false)
    @Schema(description = "user's password")
    private String password;

    @Column(name = "role",nullable = false)
    @Schema(description = "user role",example = "Admin")
    private String role;
}
