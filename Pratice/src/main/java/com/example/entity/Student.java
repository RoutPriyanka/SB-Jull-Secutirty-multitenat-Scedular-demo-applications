package com.example.entity;

public class Student {
	private int stdid;
	private String stdname;
	private String stdschool;
	
	
	public int getStdid() {
		return stdid;
	}
	public void setStdid(int stdid) {
		this.stdid = stdid;
	}
	public String getStdname() {
		return stdname;
	}
	public void setStdname(String stdname) {
		this.stdname = stdname;
	}
	public String getStdschool() {
		return stdschool;
	}
	public void setStdschool(String stdschool) {
		this.stdschool = stdschool;
	}
	@Override
	public String toString() {
		return "Student [stdid=" + stdid + ", stdname=" + stdname + ", stdschool=" + stdschool + "]";
	}
	
	
	
	

	

}
