package com.victorhugo.authmodule.dto;

import com.victorhugo.authmodule.enums.Role;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {
    private Long id;
    private UUID uuid;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private LocalDate registrationDate;
    private ZonedDateTime lastSession;
    private Boolean deleted = Boolean.FALSE;
    private Role userRole;
}
