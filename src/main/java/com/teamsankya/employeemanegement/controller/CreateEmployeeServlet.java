
package com.teamsankya.employeemanegement.controller;

import javax.servlet.http.HttpServlet;
import java.sql.Date;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.jmx.LoggerDynamicMBean;

import com.teamsankya.employeemanagement.dao.EmployeeManagementDAO;
import com.teamsankya.employeemanagement.dto.EmpAddrInfo;
import com.teamsankya.employeemanagement.dto.EmpBasicInfo;
import com.teamsankya.employeemanagement.dto.EmpCompInfo;
import com.teamsankya.employeemanagement.dto.EmpLstCmpInfo;
import com.teamsankya.employeemanagement.dto.EmpPersonalInfo;
import com.teamsankya.employeemanagement.dto.EmployeeBean;
import com.teamsankya.employeemanagement.util.EmployeeServiceManager;
import com.teamsankya.employeemanagement.util.IdGenerator;


public class CreateEmployeeServlet extends HttpServlet {
	
	final static Logger logger = Logger.getLogger(CreateEmployeeServlet.class);
	
	//@SuppressWarnings("deprecation")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		logger.info("program started");
		logger.info(resp);
		logger.info("created first object info object");
		EmployeeManagementDAO dao = EmployeeServiceManager
				.getInstence()
				.daoGenarater();
		
		
		String id =IdGenerator.uniqueId();
		
		
		EmpBasicInfo info = new EmpBasicInfo();
		info.setFname(req.getParameter("fname"));
		info.setLname(req.getParameter("lname"));
		info.setId((req.getParameter("eid")));

		logger.info("created employee address info object");
		info.setId(id);

		EmpAddrInfo addr = new EmpAddrInfo();
		addr.setId(id);
		addr.setAddr1(req.getParameter("addr1"));
		addr.setAddr2(req.getParameter("addr2"));
		addr.setCity(req.getParameter("city"));
		addr.setPincode(Integer.parseInt(req.getParameter("pincode")));

		logger.info("setting and getting values");
		EmpCompInfo comp = new EmpCompInfo();
		comp.setId(id);
		comp.setDesignation(req.getParameter("designation"));
		comp.setDoj(java.sql.Date.valueOf(req.getParameter("date_of_join")));
		comp.setCtc(Integer.parseInt(req.getParameter("CTC")));
		
		logger.info("created employee company info");
		EmpLstCmpInfo last = new EmpLstCmpInfo();
		last.setId(id);
		last.setExp(req.getParameter("exp"));
		last.setLastComp(req.getParameter("last_comp"));
		
		logger.info("created employee personal details");
		EmpPersonalInfo per = new EmpPersonalInfo();
		per.setId(id);
		per.setEmail(req.getParameter("email"));
		per.setCellNo(Long.parseLong(req.getParameter("mob_num")));
		per.setDob(java.sql.Date.valueOf(req.getParameter("DOB")));

	


		EmployeeBean bean = new EmployeeBean();
		bean.setAddr(addr);
		bean.setBasic(info);
		bean.setComp(comp);
		bean.setLstcmp(last);
		bean.setPersonal(per);
		
		
		boolean result =dao.createEmployee(bean);
		System.out.println(result);
		req.getRequestDispatcher("CreateEmployeeResponse.jsp")
		.forward(req, resp);
		
		logger.info("program ended");
		
	}
}

