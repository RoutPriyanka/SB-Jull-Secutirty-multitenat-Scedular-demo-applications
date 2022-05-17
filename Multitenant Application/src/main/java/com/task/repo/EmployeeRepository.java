package com.task.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.bean.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
	Employee findByName(String name);
	 
	  void deleteByName(String name);

}


