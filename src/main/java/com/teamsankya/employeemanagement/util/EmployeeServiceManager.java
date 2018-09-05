package com.teamsankya.employeemanagement.util;


import java.io.FileNotFoundException;
import java.io.FileReader;


import java.util.Properties;

import org.apache.log4j.Logger;

import com.teamsankya.employeemanagement.dao.EmployeeManagementDAO;
import com.teamsankya.employeemanagement.dto.EmpBasicInfo;


public class EmployeeServiceManager {
	
	final static Logger logger = Logger.getLogger(EmployeeServiceManager.class);
	
private EmployeeServiceManager() {}
	
	private static final EmployeeServiceManager EMPLOYEE_SERVICE_MANAGER = new EmployeeServiceManager();
	public static EmployeeServiceManager getInstence() {
		
		logger.info("employee service manager class started");
		
		return EMPLOYEE_SERVICE_MANAGER;
	}
	public EmployeeManagementDAO daoGenarater() {
		Properties properties = new Properties();
		String path = getClass().getResource("/employee-config.properties").getPath();
		
		try {
			FileReader fileReader = new FileReader(path);
			properties.load(fileReader);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		EmployeeManagementDAO dao = null;
		
		try {
			dao = (EmployeeManagementDAO)Class
					.forName(properties.getProperty("dao_class"))
					.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dao;
	}}


