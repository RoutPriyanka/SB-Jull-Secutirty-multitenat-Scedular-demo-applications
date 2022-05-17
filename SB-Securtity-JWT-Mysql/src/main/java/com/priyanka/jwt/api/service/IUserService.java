package com.priyanka.jwt.api.service;

import java.util.Optional;

import com.priyanka.jwt.api.model.User;

public interface IUserService {
	
	Integer saveUser(User user);
	Optional<User> findByUsername(String username);

	
}
