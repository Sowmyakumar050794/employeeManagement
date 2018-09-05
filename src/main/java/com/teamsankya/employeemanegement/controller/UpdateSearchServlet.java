package com.teamsankya.employeemanegement.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teamsankya.employeemanagement.dao.EmployeeManagementDAO;
import com.teamsankya.employeemanagement.dto.EmployeeBean;
import com.teamsankya.employeemanagement.util.EmployeeServiceManager;

public class UpdateSearchServlet extends HttpServlet {
	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	String eid =req.getParameter("eid");
	EmployeeManagementDAO dao = EmployeeServiceManager
			.getInstence()
			.daoGenarater();
	/*String eid = dao.getEid(name);
	EmployeeBean bean = dao.getEmployee(eid);
	*/
	
	
	EmployeeBean bean = dao.getEmployee(eid);
	System.out.println(bean);
	if(bean!=null)
	{
		req.setAttribute("bean", bean);
		req.getRequestDispatcher("updateprofile.jsp")
		.forward(req, resp);
	}
	else
	{
		req.getRequestDispatcher("updateerrorresponse.jsp")
		.forward(req, resp);
	}
	
	
	
	

}
}
