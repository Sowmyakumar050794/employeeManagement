package com.teamsankya.employeemanagement.dao;

import java.util.Random;

import com.teamsankya.employeemanagement.dto.EmployeeBean;

public interface EmployeeManagementDAO {
	public boolean createEmployee( EmployeeBean bean);
	public EmployeeBean getEmployee(String id);
	public EmployeeBean updateData(String id, EmployeeBean bean);
	public boolean deleteEmployee(String id);
	
	public default   String idGenerator()
	{ 
		char[] idChar = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o'
				,'p','q','r','s','t','u','v','w','x','y','z'
				,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V'
				,'V','W','X','Y','Z','1','2','3','4','5','6','7','8','9','0'};
		String id ="";
		Random random = new Random();
		for (int i = 0; i < 8; i++) {
			int index = random.nextInt(idChar.length);
			id=id+idChar[index];
		}
		return id;
	}
	
	public default String uniqueId() {
		String id = idGenerator();
		EmployeeBean bean = getEmployee(id);
		if(bean!=null)
		{
			uniqueId();
			}
		else
		{
			return id;
		}
		return id;
		
			
	}
	
	
	

	
	
}

