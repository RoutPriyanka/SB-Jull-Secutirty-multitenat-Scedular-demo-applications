package com.priyanka.jwt.api.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.priyanka.jwt.api.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
 Optional<User> findByUsername(String username);
}
