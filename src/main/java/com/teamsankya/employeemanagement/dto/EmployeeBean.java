package com.teamsankya.employeemanagement.dto;

public class EmployeeBean {
	
	
private EmpAddrInfo addr = new EmpAddrInfo();
private EmpBasicInfo basic = new EmpBasicInfo();
private EmpCompInfo comp = new EmpCompInfo();
private EmpLstCmpInfo  lstcmp = new EmpLstCmpInfo();
private EmpPersonalInfo personal = new EmpPersonalInfo();




public EmpAddrInfo getAddr() {
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
