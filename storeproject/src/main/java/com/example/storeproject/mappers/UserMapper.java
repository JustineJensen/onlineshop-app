package com.example.storeproject.mappers;

import com.example.storeproject.models.dtos.user.UserDTO;
import com.example.storeproject.models.dtos.user.UserPostDTO;
import com.example.storeproject.models.dtos.user.UserUpdateDTO;
import com.example.storeproject.models.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    @Mapping(target = "adminId", source = "admin.userId")
    public abstract UserDTO userToUserDTO(User user);

    @Mapping(target = "firstName", source = "userPostDTO.firstName")
    @Mapping(target = "lastName", source = "userPostDTO.lastName")
    @Mapping(target = "email", source = "userPostDTO.email")
    @Mapping(target = "role", source = "userPostDTO.role")
    @Mapping(target = "admin", source = "userPostDTO.admin")
    @Mapping(target = "userId", ignore = true)
    public abstract User userPostDTOToUser(UserPostDTO userPostDTO, User admin);

    // admin will not be updated directly
    @Mapping(target = "admin", ignore = true)
    public abstract User userUpdateDTOToUser(UserUpdateDTO userUpdateDTO);

    public abstract List<UserDTO> userToUserDtoList(List<User> users);

    @Named("mapSubordinatesToIds")
    public Set<Long> mapSubordinatesToIds(Set<User> source) {
        if (source == null)
            return null;
        return source.stream()
                .map(User::getUserId)
                .collect(Collectors.toSet());
    }
    @Named("mapSubordinatesToUsers")
    public Set<User> mapSubordinatesToUsers(Set<Long> source) {
        if (source == null) {
            return null;
        }
        return source.stream().map(userId -> {
            User user = new User();
            user.setUserId(userId);
            return user;
        }).collect(Collectors.toSet());
    }
}
