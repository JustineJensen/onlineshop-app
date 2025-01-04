package com.example.storeproject.models.entity;

import com.example.storeproject.utils.enumerators.AuthRole;
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
    @Schema(description = "First of user", example = "John Doe")
    private String firstName;

    @Column(name = "last_name",nullable = false)
    @Schema(description = "last of user", example ="Jensen")
    private String lastName;

    @Column(name = "email",nullable = false)
    @Schema(description = "Email of the user", example = "john.doe@example.com")
    private String email;

    @Column(name = "user_role",nullable = false)
    @Schema(description = "user role",example = "Admin role")
    private String role;

    @Enumerated(EnumType.STRING)
    @Column(name = "auth_role", nullable = false)
    @Schema(description = "The authorization role of the user", example = "AuthRole.ADMIN")
    private AuthRole authRole;
}
