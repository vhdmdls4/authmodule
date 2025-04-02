package com.victorhugo.authmodule.service.impl;

import com.victorhugo.authmodule.dto.RegisterUserDTO;
import com.victorhugo.authmodule.dto.UserDTO;
import com.victorhugo.authmodule.service.AuthService;
import com.victorhugo.authmodule.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userService.findByEmail(username);
    }

    @Override
    public UserDTO register(RegisterUserDTO registerUserDTO) {
        userService.validateIfUserExists(registerUserDTO.email(), registerUserDTO.username());
        return userService.createUser(registerUserDTO);
    }


}
