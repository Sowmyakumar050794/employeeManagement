package com.teamsankya.employeemanegement.controller ;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.teamsankya.employeemanagement.dao.EmployeeManagementDAO;
import com.teamsankya.employeemanagement.util.EmployeeServiceManager;


public class DeleteEmployeeServlet extends HttpServlet {
	
	final static Logger logger = Logger.getLogger(DeleteEmployeeServlet.class);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		logger.debug("delete employee servlet started");
		String String = (req.getParameter("eid"));
		
		logger.debug(String);
		EmployeeManagementDAO dao = EmployeeServiceManager
				.getInstence()
				.daoGenarater();
		dao.deleteEmployee(String);
		req.getRequestDispatcher("deleteEmployeeResponse.jsp")
		.forward(req, resp);

		
		
	}

}
