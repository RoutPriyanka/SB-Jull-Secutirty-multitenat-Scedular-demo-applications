package com.priyanka.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.priyanka.model.User;


@Repository
public class  UserRepository  {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int saveuser(User user) {
		return jdbcTemplate.update("INSERT INTO userTab (userid, username, userPassword) VALUES(?,?,?)",
				 new Object[] { user.getUserid(), user.getUsername(), user.getUserPassword() });
		
	}

	public List<User> getuser() {
		return (List<User>) jdbcTemplate.queryForObject("SELECT * FROM userTab",BeanPropertyRowMapper.newInstance(User.class));
	}

	public int deleteuser(Integer id) {
		 
		return jdbcTemplate.update("DELETE FROM userTab WHERE userid=?");
	}

	public int updateuser(User user) {
		return jdbcTemplate.update("UPDATE userTab SET userTab=?, usernamae=?, userpassword=? WHERE userid=?");
		
	}

}
