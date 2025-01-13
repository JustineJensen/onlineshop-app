package com.example.storeproject.models.dtos.user;

import com.example.storeproject.utils.enumerators.AuthRole;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UserPostDTO {
    private String firstName;
    private String lastName;
    private String email;
    private AuthRole authRole;
}
