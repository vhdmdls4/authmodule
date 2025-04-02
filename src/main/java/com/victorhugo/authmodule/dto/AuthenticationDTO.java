package com.victorhugo.authmodule.dto;

import java.io.Serializable;
import java.util.Optional;

public record AuthenticationDTO(String email, String password) implements Serializable {
}
