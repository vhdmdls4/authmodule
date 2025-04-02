package com.victorhugo.authmodule.controller;

import com.victorhugo.authmodule.dto.AuthenticationDTO;
import com.victorhugo.authmodule.dto.LoginResponseDTO;
import com.victorhugo.authmodule.dto.RegisterUserDTO;
import com.victorhugo.authmodule.dto.UserDTO;
import com.victorhugo.authmodule.exception.GenericException;
import com.victorhugo.authmodule.infra.security.TokenService;
import com.victorhugo.authmodule.model.User;
import com.victorhugo.authmodule.service.AuthService;
import com.victorhugo.authmodule.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authManager;
    private final AuthService authService;
    private final UserService userService;
    private final TokenService tokenService;

    @GetMapping("/test")
    public ResponseEntity<String> test(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        String token = null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            token = authorizationHeader.substring(7);
        }

        return ResponseEntity.ok("Bearer token: " + token);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AuthenticationDTO authDTO) {
        try {
            UsernamePasswordAuthenticationToken usernameAuthToken = new UsernamePasswordAuthenticationToken(authDTO.email(), authDTO.password());
            Authentication auth = authManager.authenticate(usernameAuthToken);
            String token = tokenService.generateToken((User) auth.getPrincipal());
            LoginResponseDTO loginResponseDTO = new LoginResponseDTO(token);
            return ResponseEntity.ok(loginResponseDTO);
        } catch (GenericException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody @Valid RegisterUserDTO registerUserDTO) {
        try {
            UserDTO userRegistered = authService.register(registerUserDTO);
            return ResponseEntity.ok(userRegistered);
        } catch (GenericException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
