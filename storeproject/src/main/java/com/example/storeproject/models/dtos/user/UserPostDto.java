package com.example.storeproject.models.dtos.user;

import lombok.Data;

@Data
public class UserPostDto {
    private String userName;
    private String email;
    private String password;
    private String role;
}
