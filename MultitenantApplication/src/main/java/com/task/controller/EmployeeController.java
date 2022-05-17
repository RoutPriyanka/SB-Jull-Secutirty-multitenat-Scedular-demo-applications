package com.task.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.task.bean.Employee;
import com.task.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/createemployee", method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody Employee employee) {
		employeeService.save(employee);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/getemployee/all", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getAll() throws SQLException {
		List<Employee> employees = employeeService.getAll();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	@RequestMapping(value = "/getemployee/{id}", method = RequestMethod.GET)
	public ResponseEntity<Employee> get(@PathVariable(value = "id") Long id) {
		Employee employee = employeeService.get(id);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@RequestMapping(value = "/getemployeebyname/{name}", method = RequestMethod.GET)
	public ResponseEntity<Employee> get(@PathVariable(value = "name") String name) {
		Employee employee = employeeService.getByName(name);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@RequestMapping(value = "deletebyname/{name}", method = RequestMethod.DELETE)
	public ResponseEntity<Employee> delete(@PathVariable(value = "name") String name) {
		employeeService.delete(name);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}