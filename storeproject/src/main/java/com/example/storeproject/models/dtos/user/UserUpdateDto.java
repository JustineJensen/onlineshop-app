package com.example.storeproject.models.dtos.user;

import lombok.Data;

@Data
public class UserUpdateDto {
    private long userId;
    private String userName;
    private String email;
    private String password;
    private String role;
}