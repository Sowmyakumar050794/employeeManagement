package com.teamsankya.employeemanagement.dao;

import com.teamsankya.employeemanagement.dto.EmployeeBean;

public interface EmployeeManagementDAO {
	public boolean createEmployee( EmployeeBean bean);
	public EmployeeBean getEmployee(String id);
	public EmployeeBean updateData(String id, EmployeeBean bean);
	public boolean deleteEmployee(String id);
	public String getEid(String input);
	
}

