package com.priyanka.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.priyanka.Repo.EmployeeRepository;
import com.priyanka.Repo.UserRepository;
import com.priyanka.model.Employee;
import com.priyanka.model.User;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository EmployeeRepository;
	@Autowired
	UserRepository userRepository;

	public List<Employee> getemployeedata() {
			List<Employee> findAll = EmployeeRepository.findAll();
			return findAll;
	
	}

	public List<User> getuserdata() {
		List<User> findAll = userRepository.findAll();
		return findAll;
	}

	

}
