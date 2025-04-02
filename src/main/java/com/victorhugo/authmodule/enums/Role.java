package com.victorhugo.authmodule.enums;

import lombok.Getter;

@Getter
public enum Role {
    ADMIN("ADMIN"),
    USER("USER"),
    SUPPORT("SUPPORT");

    Role(String role) {
    }
}
