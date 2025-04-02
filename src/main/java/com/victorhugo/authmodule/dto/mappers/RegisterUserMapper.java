package com.victorhugo.authmodule.dto.mappers;

import com.victorhugo.authmodule.dto.RegisterUserDTO;
import com.victorhugo.authmodule.model.User;

import java.time.LocalDate;

public class RegisterUserMapper {
    public static User toUserEntity(RegisterUserDTO registerUserDTO) {
        String passwordEncoded = registerUserDTO.password();

        return User.builder()
                .userRole(registerUserDTO.userRole())
                .lastName(registerUserDTO.lastName())
                .firstName(registerUserDTO.firstName())
                .email(registerUserDTO.email())
                .password(passwordEncoded)
                .username(registerUserDTO.username())
                .registrationDate(LocalDate.now())
                .build();
    }
}
