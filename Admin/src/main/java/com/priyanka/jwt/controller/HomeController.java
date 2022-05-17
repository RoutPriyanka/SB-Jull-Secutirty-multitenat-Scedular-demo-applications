package com.priyanka.jwt.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.priyanka.jwt. model.JWTRequest;
import com.priyanka.jwt. model.User;
import com.priyanka.jwt.service.UserService;
import com.priyanka.jwt.utility.JWTUtility;

@RestController
public class HomeController {

	@Autowired
	private JWTUtility jwtUtility;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;

	@GetMapping("/test")
	public String home() {
		return "Welccome to my home!!";
	}

	@PostMapping("/authenticate")
	public String generateToken(@RequestBody JWTRequest jwtRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequest.getUserName(), jwtRequest.getpassword()));
		} catch (BadCredentialsException ex) {
			throw new Exception("INVALID_CREDENTIALS");
		}
		

		return jwtUtility.generateToken(jwtRequest.getUserName());

	}

	@GetMapping("/user")
	private List<User> getAllUser() {
		return userService.getAllUsers();
	}
	@PostMapping("/create")
	private int saveUser(@RequestBody User user) {
		userService.saveOrUpdate(user);
		return user.getId();
	}

}
