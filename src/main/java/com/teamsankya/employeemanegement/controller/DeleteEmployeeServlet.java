package com.teamsankya.employeemanegement.controller ;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teamsankya.employeemanagement.dao.EmployeeManagementDAO;
import com.teamsankya.employeemanagement.util.EmployeeServiceManager;


public class DeleteEmployeeServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String String = (req.getParameter("eid"));
		
		
		EmployeeManagementDAO dao = EmployeeServiceManager
				.getInstence()
				.daoGenarater();
		dao.deleteEmployee(String);
		req.getRequestDispatcher("eleteEmployeeResponse.jsp")
		.forward(req, resp);

		
		
	}

}
