package com.priyanka.config;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Entity
@Data
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DataSourceConfig implements Serializable {

	private static final long serialVersionUID = 5104181924076372196L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int userid;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String url;
	@Column
	private String driverClassName;
}
