package com.teamsankya.employeemanagement.dto;

import java.util.Date;

public class EmpPersonalInfo {
	private String id ;
	private String email ;
	private long cellNo ;
	private Date dob;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getCellNo() {
		return cellNo;
	}
	public void setCellNo(long cellNo) {
		this.cellNo = cellNo;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}

}
