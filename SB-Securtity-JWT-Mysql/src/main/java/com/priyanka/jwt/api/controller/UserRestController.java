 package com.priyanka.jwt.api.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.priyanka.jwt.api.model.User;
import com.priyanka.jwt.api.model.UserRequest;
import com.priyanka.jwt.api.model.UserResponse;
import com.priyanka.jwt.api.service.IUserService;
import com.priyanka.jwt.api.util.JwtUtil;

@RestController
@RequestMapping("/user")
public class UserRestController {
	
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private IUserService service;  //Has-A
	
	@Autowired
	private JwtUtil jwtutil;
	

	
	//1.save User data in database
	
	@PostMapping("/save")
	public ResponseEntity<String> saveUser(@RequestBody User user){
		Integer id = service.saveUser(user);
		String body = "User '"+id+"'saved";
		//return new RespoonseEntity<String>(body, HttpStatus.ok);
		return ResponseEntity.ok(body);
	}
	
	//2. Validate User and generate Token(login)
	
	@PostMapping("/login")
	public ResponseEntity<UserResponse>loginUser(@RequestBody UserRequest userrequest)
	{
		
		//validate username/pswd with database
		
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						userrequest.getUsername(), 
						userrequest.getPassword()
						)
				);
		
		String token = jwtutil.generateToken(userrequest.getUsername());
		
		return ResponseEntity.ok(
				new UserResponse(token,"Sucess! Generated By PRIYANKA"));
	}
	
	//3. after login only
	public ResponseEntity<String> acessUserData(Principal p){
		return ResponseEntity.ok("Hello user!"+ p.getName());
	}
}
