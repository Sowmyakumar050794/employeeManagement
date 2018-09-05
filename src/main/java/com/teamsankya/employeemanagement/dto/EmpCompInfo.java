package com.teamsankya.employeemanagement.dto;

import java.sql.Date;

import org.apache.log4j.Logger;

public class EmpCompInfo {

	final static Logger logger = Logger.getLogger(EmpCompInfo.class);
	
	private String id ;
	private String designation ;
	private Date doj;
	public Date getDoj() {
		
		logger.info("generating getters and setters method for employee company info table");
		
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	private int ctc ;
	
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getCtc() {
		return ctc;
	}
	public void setCtc(int ctc) {
		this.ctc = ctc;
	}
	
	
	
	
}
