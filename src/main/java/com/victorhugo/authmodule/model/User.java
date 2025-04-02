package com.victorhugo.authmodule.model;

import com.victorhugo.authmodule.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@SQLDelete(sql = "UPDATE users SET deleted = true WHERE id = ?")
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private UUID uuid;
    @Column(nullable = false)
    @NotBlank
    private String username;
    @Column(nullable = false)
    @NotBlank
    private String email;
    @Column(nullable = false)
    @NotBlank
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate registrationDate;
    private ZonedDateTime lastSession;
    private Boolean deleted;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotBlank
    private Role userRole;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        switch (this.userRole){
            case ADMIN -> {
                return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
            }
            case USER -> {
                return List.of(new SimpleGrantedAuthority("ROLE_USER"));
            }
            default -> {
                return List.of(new SimpleGrantedAuthority(null));
            }
        }
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
