package com.example.storeproject.models.dtos.user;

import lombok.Data;

@Data
public class UserPostDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String role;
}
