package com.priyanka.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="usertab")
public class User {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private String username; 
	private String password;

}
