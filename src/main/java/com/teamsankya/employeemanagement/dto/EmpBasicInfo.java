package com.teamsankya.employeemanagement.dto;

import org.apache.log4j.Logger;

public class EmpBasicInfo {

	private String id;
	private String fname;
	private String lname;

	public String getId() {

		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

}
