package com.victorhugo.authmodule.dto;

import java.io.Serializable;

public record LoginResponseDTO(String token) implements Serializable {
}
