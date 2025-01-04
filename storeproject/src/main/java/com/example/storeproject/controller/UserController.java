package com.example.storeproject.controller;

import com.example.storeproject.mappers.UserMapper;
import com.example.storeproject.models.dtos.user.UserDTO;
import com.example.storeproject.models.entity.User;
import com.example.storeproject.services.user.UserService;
import com.example.storeproject.utils.ApiErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping
@Tag(name ="User",description = "Endpoints nto interact with Users")
public class UserController {
    private final UserService userService;
    private  final UserMapper userMapper;
@Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }
    @Operation(summary = "Get a list of all users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = UserDTO.class)))
            }),
            @ApiResponse(responseCode = "400", description = "Malformed request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class))),
    })
    @GetMapping
    @CrossOrigin
    public ResponseEntity<Collection<UserDTO>>getAllUsers(){
    Collection<User>users = userService.findAll();
    Collection<UserDTO> userDTOS = new ArrayList<>();
    for(User user :users){
        userDTOS.add(userMapper.userToUserDTO(user));
    }
    return new ResponseEntity<>(userDTOS, HttpStatus.OK);
    }
}
