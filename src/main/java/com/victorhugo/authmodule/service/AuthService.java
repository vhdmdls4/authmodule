package com.victorhugo.authmodule.service;

import com.victorhugo.authmodule.dto.RegisterUserDTO;
import com.victorhugo.authmodule.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface AuthService extends UserDetailsService {
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
    UserDTO register(RegisterUserDTO registerUserDTO);
}
