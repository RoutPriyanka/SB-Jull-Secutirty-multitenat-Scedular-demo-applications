package com.priyanka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.priyanka.Service.EmployeeService;
import com.priyanka.model.Employee;
import com.priyanka.model.User;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService EmployeeService;
	

	@GetMapping("/getemployeedeta")
	public List<Employee> GetEmployeeData() {
	List<Employee> getemployeedata = EmployeeService.getemployeedata();
   return getemployeedata;
	
	}
	@GetMapping("/getuserdeta")
	public List<User> GetUserData() {
	List<User> getuserdata = EmployeeService.getuserdata();
   return getuserdata;
	
	}

}
