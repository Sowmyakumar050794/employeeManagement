package com.teamsankya.employeemanegement.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.teamsankya.employeemanagement.dao.EmployeeManagementDAO;
import com.teamsankya.employeemanagement.dto.EmployeeBean;
import com.teamsankya.employeemanagement.util.EmployeeServiceManager;

public class GetEmpServlet extends HttpServlet {

	final static Logger logger = Logger.getLogger(CreateEmployeeServlet.class);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		logger.info(req);
		String name = req.getParameter("name");
		EmployeeManagementDAO dao = EmployeeServiceManager
				.getInstence()
				.daoGenarater();
		/*String eid = dao.getEid(name);
		EmployeeBean bean = dao.getEmployee(eid);
		*/
		logger.fatal(name);
		EmployeeBean bean = dao.getEmployee(dao.getEid(name));
		System.out.println(bean);
		req.getRequestDispatcher("searchEmployeeResponse.jsp")
		.forward(req, resp);
	}
}
