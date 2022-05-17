package com.task.service;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.joda.MillisecondInstantPrinter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.task.bean.Employee;
import com.task.repo.EmployeeRepository;



@Component

public class EmployeeService {
	
	
	private static final List<Employee> Employee = null;
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	  public void save(Employee employee) {
		  employeeRepository.save(employee);
	    }
	  
	  public List<Employee> getAll() throws SQLException {
		    return employeeRepository.findAll();

	    }

	    public Employee get(Long id) {
	        return employeeRepository.findById(id).get();
	    }

	    public Employee getByName(String name) {
	        return employeeRepository.findByName(name);
	    }

	    public void delete(String name) {
	    	employeeRepository.deleteByName(name);
	    }
	    Logger log=LoggerFactory.getLogger(EmployeeService.class);
	 
//	    @Scheduled(fixedDelay =600000)
//	    public void scheduler() throws InterruptedException{
//	    	LocalDateTime current = LocalDateTime.now();
//	    	DateTimeFormatter format = DateTimeFormatter.ofPattern("dd=MM-yyy HH:mm:ss");
//	    	String formattedDateTime =current.format(format);
//	    	log.info("Scheduler time "+ formattedDateTime);
//	    	
//	  
//	    }  


	
}


