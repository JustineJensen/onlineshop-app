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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    @Schema(description = "ID of the user", example = "1234")
    private Long userId;

    @Column(name = "first_name", nullable = false)
    @Schema(description = "First name of user", example = "John Doe")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @Schema(description = "Last name of user", example = "Jensen")
    private String lastName;

    @Column(name = "email", nullable = false,unique = true)
    @Schema(description = "Email of the user", example = "john.doe@example.com")
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "auth_role", nullable = false)
    @Schema(description = "The authorization role of the user", example = "AuthRole.ADMIN")
    private AuthRole authRole;

}
