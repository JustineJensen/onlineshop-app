package com.example.storeproject.models.dtos.user;

import com.example.storeproject.utils.enumerators.AuthRole;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserDTO {
    @Schema(description = " generated user ID",example = "1233")
    private long userId;
    @Schema(description = "First name of the user", example = "John")
    private String firstName;
    @Schema(description = "Last name of the user", example = "Doe")
    private String lastName;
    @Schema(description = "Email of the user", example = "john.doe@gmail.com")
    private String email;
    @Schema(description = "The authorization role of the user", example = "AuthRole.ADMIN")
    private AuthRole authRole;
}
