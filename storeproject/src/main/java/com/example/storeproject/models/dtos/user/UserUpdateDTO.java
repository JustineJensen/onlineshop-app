package com.example.storeproject.models.dtos.user;

import lombok.Data;

@Data
public class UserUpdateDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String role;
}
