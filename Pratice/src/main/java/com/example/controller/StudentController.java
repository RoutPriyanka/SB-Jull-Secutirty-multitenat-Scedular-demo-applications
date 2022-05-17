package com.example.controller;

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

import com.example.entity.Student;
import com.example.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/recivedstudentdata")
	public String recivedstudentdata(@RequestBody Student student) {
		studentService.recivedstudent(student);
		return"recived sucessfully";
	}
	
	@GetMapping("/getstudentdata")
	public List<Student> getstudentdata(){
		List<Student> getstudentdata = studentService.getstudentdata();
		return getstudentdata;
	}
	@DeleteMapping("/deletestudent/{id}")
	public String deletestudent(@PathVariable Integer no) {
		studentService.deletestudent(no);
		return"deleted sussfully";
		
	}
	@PutMapping("/updatestudent")
	public String updatestudent(@RequestBody Student student) {
		studentService.updatestudent(student);
		return"student sucessfuly updated";
	}
	
	

}
