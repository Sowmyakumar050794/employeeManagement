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

	final static Logger logger = Logger.getLogger(GetEmpServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("keyword");


		EmployeeManagementDAO dao = EmployeeServiceManager
				.getInstence()
				.daoGenarater();
		/*String eid = dao.getEid(name);
		EmployeeBean bean = dao.getEmployee(eid);
		*/

		logger.fatal(name);
		EmployeeBean bean = dao.getEmployee(name);
		System.out.println(bean);
		req.getRequestDispatcher("searchEmployeeResponse.jsp")
		.forward(req, resp);
	}
}
