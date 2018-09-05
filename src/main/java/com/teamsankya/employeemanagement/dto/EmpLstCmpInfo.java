package com.teamsankya.employeemanagement.dto;

import org.apache.log4j.Logger;

public class EmpLstCmpInfo {
	
	final static Logger logger = Logger.getLogger(EmpLstCmpInfo.class);
	
	private String id ;
	private String lastComp ;
	private String exp ;
	
	
	public String getId() {
		logger.info("generating getters and setters method for employee last company info table");
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLastComp() {
		return lastComp;
	}
	public void setLastComp(String lastComp) {
		this.lastComp = lastComp;
	}
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	
	
	
	
}
