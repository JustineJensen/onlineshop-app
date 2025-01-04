package com.example.storeproject.models.dtos.user;

import lombok.Data;

@Data
public class UserDTO {
    private long userId;
    private String firstName;
    private String lastName;
    private String email;
    private long adminId;
    private String role;
}
