package com.example.storeproject.models.dtos.user;

import com.example.storeproject.utils.enumerators.AuthRole;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserDTO {
    private long userId;
    private String firstName;
    private String lastName;
    private String email;
    private AuthRole authRole;
}
