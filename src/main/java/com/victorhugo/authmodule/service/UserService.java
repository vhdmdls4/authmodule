package com.victorhugo.authmodule.service;

import com.victorhugo.authmodule.dto.RegisterUserDTO;
import com.victorhugo.authmodule.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserDetails findByEmail(String username);
    void validateIfUserExists(String email, String username);
    UserDTO createUser(RegisterUserDTO registerUserDTO);
}
