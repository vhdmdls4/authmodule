package com.victorhugo.authmodule.service.impl;

import com.victorhugo.authmodule.dto.RegisterUserDTO;
import com.victorhugo.authmodule.dto.UserDTO;
import com.victorhugo.authmodule.dto.mappers.RegisterUserMapper;
import com.victorhugo.authmodule.dto.mappers.UserMapper;
import com.victorhugo.authmodule.exception.GenericException;
import com.victorhugo.authmodule.model.User;
import com.victorhugo.authmodule.repository.UserRepository;
import com.victorhugo.authmodule.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserDetails findByEmail(String username) {
        return userRepository.findByEmail(username);
    }

    @Override
    public void validateIfUserExists(String email, String username) {
        userRepository.findByEmailOrUsername(username, email)
                .ifPresent(user -> {
                    throw new GenericException("Já existe um cadastro com esse username e/ou esse email");
                });
    }

    @Override
    @Transactional(rollbackFor = GenericException.class)
    public UserDTO createUser(RegisterUserDTO registerUserDTO) {
        User userMapped = RegisterUserMapper.toUserEntity(registerUserDTO);
        User userPersisted = userRepository.save(userMapped);
        return UserMapper.toDTO(userPersisted);
    }
}
