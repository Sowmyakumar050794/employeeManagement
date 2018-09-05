package com.teamsankya.employeemanagement.dto;

import org.apache.log4j.Logger;

public class EmployeeBean {
	
	final static Logger logger = Logger.getLogger(EmployeeBean.class);
	
private EmpAddrInfo addr = new EmpAddrInfo();
private EmpBasicInfo basic = new EmpBasicInfo();
private EmpCompInfo comp = new EmpCompInfo();
private EmpLstCmpInfo  lstcmp = new EmpLstCmpInfo();
private EmpPersonalInfo personal = new EmpPersonalInfo();




public EmpAddrInfo getAddr() {

	logger.info("generating getters and setters method for employee bean info table");
	
	return addr;
}
public void setAddr(EmpAddrInfo addr) {
	this.addr = addr;
}
public EmpBasicInfo getBasic() {
	return basic;
}
public void setBasic(EmpBasicInfo basic) {
	this.basic = basic;
}
public EmpCompInfo getComp() {
	return comp;
}
public void setComp(EmpCompInfo comp) {
	this.comp = comp;
}
public EmpLstCmpInfo getLstcmp() {
	return lstcmp;
}
public void setLstcmp(EmpLstCmpInfo lstcmp) {
	this.lstcmp = lstcmp;
}
public EmpPersonalInfo getPersonal() {
	return personal;
}
public void setPersonal(EmpPersonalInfo personal) {
	this.personal = personal;
}




}
