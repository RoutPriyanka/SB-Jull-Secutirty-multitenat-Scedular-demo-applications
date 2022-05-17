package com.priyanka.model;

public class User {
	
	 private int userid;
	 private String username;
	 private String userPassword;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", userPassword=" + userPassword + "]";
	}
	 

}
