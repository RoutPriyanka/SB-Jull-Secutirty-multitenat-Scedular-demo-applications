package com.priyanka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.priyanka.model.User;
import com.priyanka.repository.UserRepository;

@RestController
@RequestMapping("/User")

public class UserController {
	@Autowired
	private UserRepository userRepo;

	@PostMapping("/saveuser")
	public String saveuser(@RequestBody User user) {
		userRepo.saveuser(user);
		return "uswer data saved sucessfully";

	}

	@GetMapping("/getuser")
	public List<User> getuser() {
		List<User> getuser = userRepo.getuser();
		return getuser;
	}

	@DeleteMapping("/deleteuser/{id}")
	public String deleteuser(@PathVariable Integer id) {
		userRepo.deleteuser(id);
		return "user data is deleted";
	}

	@PutMapping("/updateuser")
	public String updateuser(@RequestBody User user) {

		userRepo.updateuser(user);
		return "User sucessfully updated";

	}

}
