package com.victorhugo.authmodule.repository;

import com.victorhugo.authmodule.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByEmail (String email);

    Optional<User> findByEmailOrUsername(String email, String username);
}
