package com.victorhugo.authmodule.dto.mappers;

import com.victorhugo.authmodule.dto.UserDTO;
import com.victorhugo.authmodule.model.User;

public class UserMapper {
    public static UserDTO toDTO(User user){
        return UserDTO.builder()
                .id(user.getId())
                .uuid(user.getUuid())
                .email(user.getEmail())
                .username(user.getUsername())
                .password(user.getPassword())
                .lastSession(user.getLastSession())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .registrationDate(user.getRegistrationDate())
                .userRole(user.getUserRole())
                .deleted(user.getDeleted())
                .build();
    }
    public static User toEntity(UserDTO userDto){
        return User.builder()
                .id(userDto.getId())
                .uuid(userDto.getUuid())
                .email(userDto.getEmail())
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .lastSession(userDto.getLastSession())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .registrationDate(userDto.getRegistrationDate())
                .userRole(userDto.getUserRole())
                .deleted(userDto.getDeleted())
                .build();
    }
}
