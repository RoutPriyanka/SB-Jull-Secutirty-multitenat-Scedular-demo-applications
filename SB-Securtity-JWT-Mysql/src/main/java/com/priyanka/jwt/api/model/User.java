package com.priyanka.jwt.api.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "usrtab")
@Data
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String username;
	private String password;
	
	//it is optional 
	/*
	 * @ElementCollection(fetch = FetchType.EAGER)
	 * 
	 * @CollectionTable( name = "rolestab", joinColumns = @JoinColumn(name = "id") )
	 * 
	 * @Column(name = "role") private Set<String> roles;
	 */
	
	@ElementCollection
	private List<String> roles;
}
