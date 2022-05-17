package com.priyanka.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.priyanka.jwt.Repo.UserRepository;
import com.priyanka.jwt. model.User;

@Service
public class UserService {
	@Autowired
	UserRepository userRepo;

	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	public void saveOrUpdate(User user) {
		userRepo.save(user);
	}

}
