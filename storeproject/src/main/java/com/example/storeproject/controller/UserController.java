package com.example.storeproject.controller;

import com.example.storeproject.mappers.UserMapper;
import com.example.storeproject.models.dtos.user.UserDTO;
import com.example.storeproject.models.dtos.user.UserPostDTO;
import com.example.storeproject.models.dtos.user.UserUpdateDTO;
import com.example.storeproject.models.entity.User;
import com.example.storeproject.services.user.UserService;
import com.example.storeproject.utils.ApiErrorResponse;
import com.example.storeproject.utils.enumerators.AuthRole;
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
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/api/v1/users")
@Tag(name ="User",description = "Endpoints nto interact with Users")
public class UserController {
    private final UserService userService;
    private  final UserMapper userMapper;
@Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }
    //Get list of users
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
     // get user by ID
    @CrossOrigin
    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO>getUserById(@PathVariable long userId){
    User user = userService.findById(userId);
    UserDTO dto = userMapper.userToUserDTO(user);
    if(user != null){
        return  new ResponseEntity<>(dto,HttpStatus.OK);
    }else{
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    }
    // Create a new user
    @Operation(summary = "Create a new User")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = UserPostDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Malformed request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class)))
    })
    @PostMapping
    @CrossOrigin
    public  ResponseEntity<Void>createNewUser(@RequestBody UserPostDTO userPostDTO) {
        try {
            User user = new User();
            user.setEmail(userPostDTO.getEmail());
            user.setFirstName(userPostDTO.getFirstName());
            user.setLastName(userPostDTO.getLastName());
            user.setAuthRole(userPostDTO.getAuthRole() != null ? userPostDTO.getAuthRole() : AuthRole.USER);
            userService.add(user);
            return ResponseEntity.ok().build();
        } catch (RuntimeException ex) {
            System.err.println("Error creating User" + ex.getMessage());

            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }catch (Exception ex){
            System.err.println("Unexpected error:" + ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
    @Operation(summary = "Update an existing user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "No content", content = @Content),
            @ApiResponse(responseCode = "400", description = "Malformed request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class))),
    })
    @CrossOrigin
    @PutMapping("/{userId}")
    public ResponseEntity<Void>updateUser(@PathVariable Long userId, @RequestBody UserUpdateDTO userUpdateDTO){
    User existingUser = userService.findById(userId);
    if(existingUser == null){
        return ResponseEntity.notFound().build();
    }
    existingUser.setFirstName(userUpdateDTO.getFirstName());
    existingUser.setLastName(userUpdateDTO.getLastName());
    existingUser.setEmail(userUpdateDTO.getEmail());
    existingUser.setAuthRole((userUpdateDTO.getAuthRole()));
    userService.update(existingUser);
 return  ResponseEntity.noContent().build();
}
    @Operation(summary = "Delete a User by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "No content", content = @Content),
            @ApiResponse(responseCode = "400", description = "Malformed request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class))),
    })
@DeleteMapping("/{userId}")
 public ResponseEntity<Void>deleteUser(@PathVariable Long userId){
    User user = userService.findById(userId);
    userService.deleteById(userId);
    return  ResponseEntity.noContent().build();
 }

}
