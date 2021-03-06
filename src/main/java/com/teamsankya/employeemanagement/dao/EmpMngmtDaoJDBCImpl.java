package com.teamsankya.employeemanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import org.apache.log4j.Logger;

import com.teamsankya.employeemanagement.dto.EmpAddrInfo;
import com.teamsankya.employeemanagement.dto.EmpBasicInfo;
import com.teamsankya.employeemanagement.dto.EmpCompInfo;
import com.teamsankya.employeemanagement.dto.EmpLstCmpInfo;
import com.teamsankya.employeemanagement.dto.EmpPersonalInfo;
import com.teamsankya.employeemanagement.dto.EmployeeBean;
import com.teamsankya.employeemanegement.controller.CreateEmployeeServlet;

public class EmpMngmtDaoJDBCImpl implements EmployeeManagementDAO {
	
	final static Logger logger = Logger.getLogger(EmpMngmtDaoJDBCImpl.class);

	@Override
	public boolean createEmployee(EmployeeBean bean) {
		
		logger.info("implementing creating employee method");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try (Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/employee_management?user=root&password=root");
					PreparedStatement pstmt1 = con.prepareStatement("INSERT INTO employeebasic_info VALUES(?,?,?)");
					PreparedStatement pstmt2 = con
							.prepareStatement("INSERT INTO employeeaddress_info VALUES(?,?,?,?,?)");
					PreparedStatement pstmt3 = con
							.prepareStatement("INSERT INTO employeepersonal_info VALUES(?,?,?,?)");
					PreparedStatement pstmt4 = con
							.prepareStatement("INSERT INTO employeelastcompany_info VALUES(?,?,?)");
					PreparedStatement pstmt5 = con
							.prepareStatement("INSERT INTO employeecompany_info VALUES(?,?,?,?)");) {

				pstmt1.setString(1, bean.getBasic().getId());
				pstmt1.setString(2, bean.getBasic().getFname());
				pstmt1.setString(3, bean.getBasic().getLname());

				pstmt2.setString(1, bean.getAddr().getId());
				pstmt2.setString(2, bean.getAddr().getAddr1());
				pstmt2.setString(3, bean.getAddr().getAddr2());
				pstmt2.setString(4, bean.getAddr().getCity());
				pstmt2.setInt(5, bean.getAddr().getPincode());

				pstmt3.setString(1, bean.getPersonal().getId());
				pstmt3.setString(2, bean.getPersonal().getEmail());
				pstmt3.setLong(3, bean.getPersonal().getCellNo());
				pstmt3.setDate(4, bean.getPersonal().getDob());

				pstmt4.setString(1, bean.getLstcmp().getId());
				pstmt4.setString(2, bean.getLstcmp().getExp());
				pstmt4.setString(3, bean.getLstcmp().getLastComp());

				pstmt5.setString(1, bean.getComp().getId());
				pstmt5.setString(2, bean.getComp().getDesignation());
				pstmt5.setDate(3, bean.getComp().getDoj());
				pstmt5.setLong(4, bean.getComp().getCtc());

				boolean p1 = pstmt1.execute();
				boolean p2 = pstmt2.execute();
				boolean p3 = pstmt3.execute();
				boolean p4 = pstmt4.execute();
				boolean p5 = pstmt5.execute();
				System.out.println(p1 + " " + p2 + " " + p3 + " " + p4 + " " + p5);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public EmployeeBean getEmployee(String id) {
		
		logger.info("implementing retreive employee method");

		EmpBasicInfo info = new EmpBasicInfo();
		EmpAddrInfo addr = new EmpAddrInfo();
		EmpCompInfo comp = new EmpCompInfo();
		EmpLstCmpInfo last = new EmpLstCmpInfo();
		EmpPersonalInfo per = new EmpPersonalInfo();
		EmployeeBean bean = new EmployeeBean();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			try (Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/employee_management?user=root&password=root");){
					con.setAutoCommit(false);
					PreparedStatement pstmt1 = con
							.prepareStatement("SELECT * FROM employeebasic_info bi, employeeaddress_info ai,\r\n"
									+ "	employeepersonal_info pi, employeelastcompany_info lci,\r\n"
									+ "	employeecompany_info ci WHERE bi.eid=ai.eid and ai.eid=pi.eid and pi.eid=lci.eid"
									+ "	and lci.eid=ci.eid and (bi.eid like ? or bi.fname like ? or bi.lname like ? "
									+ "	or ci.designation like ? or pi.email like ? or pi.mob_num like ?);"); {

				pstmt1.setString(1, "%"+id+"%");
				pstmt1.setString(2, "%"+id+"%");
				pstmt1.setString(3, "%"+id+"%");
				pstmt1.setString(4, "%"+id+"%");
				pstmt1.setString(5, "%"+id+"%");
				pstmt1.setString(6, "%"+id+"%");
				try (ResultSet rs = pstmt1.executeQuery()) {
					if (rs.next()) {
						System.out.println("Employee found");
						
						info.setId(id);
						info.setId(rs.getString("eid"));
						info.setFname(rs.getString("fname"));
						info.setLname(rs.getString("lname"));

						addr.setId(id);
						addr.setAddr1(rs.getString("addr1"));
						addr.setAddr2(rs.getString("addr2"));
						addr.setCity(rs.getString("city"));
						addr.setPincode(rs.getInt("pincode"));

						comp.setId(id);
						comp.setDesignation(rs.getString("designation"));
						comp.setCtc(rs.getInt("CTC"));
						comp.setDoj(rs.getDate("date_of_join"));

						last.setId(id);
						last.setExp(rs.getString("exp"));
						last.setLastComp(rs.getString("last_comp"));

						per.setId(id);
						per.setCellNo(rs.getLong("mob_num"));
						per.setEmail(rs.getString("email"));
						per.setDob(rs.getDate("DOB"));

						bean.setAddr(addr);
						bean.setBasic(info);
						bean.setComp(comp);
						bean.setLstcmp(last);
						bean.setPersonal(per);
						return bean;

					} else {
						return null;
					}

				}
			}}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public EmployeeBean updateData(String id, EmployeeBean bean) {

		logger.info("implementing updating employee method");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try (Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/employee_management?user=root&password=root");)
					{
				con.setAutoCommit(false);
					PreparedStatement pstmt1 = con
							.prepareStatement("UPDATE employeebasic_info SET FNAME=?,LNAME=? WHERE EID=?");
					PreparedStatement pstmt2 = con.prepareStatement(
							"UPDATE employeeaddress_info SET ADDR1=?,ADDR2=?,CITY=?,PINCODE=? WHERE EID=?");
					PreparedStatement pstmt3 = con
							.prepareStatement("UPDATE employeepersonal_info SET EMAIL=?,MOB_NUM=?,DOB=? WHERE EID=?");
					PreparedStatement pstmt4 = con
							.prepareStatement("UPDATE employeelastcompany_info SET EXP=?,LAST_COMP=? WHERE EID=?");
					PreparedStatement pstmt5 = con.prepareStatement(
							"UPDATE employeecompany_info SET DESIGNATION=?,DATE_OF_JOIN=?,CTC=? WHERE EID=?"); {
								

				pstmt1.setString(3, id);
				pstmt1.setString(1, bean.getBasic().getFname());
				pstmt1.setString(2, bean.getBasic().getLname());

				pstmt2.setString(5, id);
				pstmt2.setString(1, bean.getAddr().getAddr1());
				pstmt2.setString(2, bean.getAddr().getAddr2());
				pstmt2.setString(3, bean.getAddr().getCity());
				pstmt2.setInt(4, bean.getAddr().getPincode());

				pstmt3.setString(4, id);
				pstmt3.setString(1, bean.getPersonal().getEmail());
				pstmt3.setLong(2, bean.getPersonal().getCellNo());
				pstmt3.setDate(3, bean.getPersonal().getDob());

				pstmt4.setString(3, id);
				pstmt4.setString(1, bean.getLstcmp().getExp());
				pstmt4.setString(2, bean.getLstcmp().getLastComp());

				pstmt5.setString(4, id);
				pstmt5.setString(1, bean.getComp().getDesignation());
				pstmt5.setDate(2, bean.getComp().getDoj());
				pstmt5.setLong(3, bean.getComp().getCtc());

				int c1 = pstmt1.executeUpdate();
				System.out.println(c1);
				int c2 = pstmt2.executeUpdate();
				System.out.println(c2);
				int c3 = pstmt3.executeUpdate();
				System.out.println(c3);
				int c4 = pstmt4.executeUpdate();
				System.out.println(c4);
				int c5 = pstmt5.executeUpdate();
				System.out.println(c5);

				con.commit();
				int fin = c1+c2+c3+c4+c5;
				if(fin!=5)
				{
					return null;
				}
				else {
					return bean;
				}
			}
		}
		}



		catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}


	@Override
	public boolean deleteEmployee(String id) {
		
		logger.info("implementing delete employee method");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try (Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/employee_management?user=root&password=root")) {
				con.setAutoCommit(false);

				try (PreparedStatement pstmt1 = con.prepareStatement("DELETE FROM employeebasic_info WHERE EID=? ");
						PreparedStatement pstmt2 = con
								.prepareStatement("DELETE FROM employeeaddress_info WHERE EID=? ");
						PreparedStatement pstmt3 = con
								.prepareStatement("DELETE FROM employeepersonal_info WHERE EID=? ");
						PreparedStatement pstmt4 = con
								.prepareStatement("DELETE FROM employeelastcompany_info WHERE EID=? ");
						PreparedStatement pstmt5 = con
								.prepareStatement("DELETE FROM employeecompany_info WHERE EID=? ");) {

					pstmt1.setString(1, id);
					pstmt2.setString(1, id);
					pstmt3.setString(1, id);
					pstmt4.setString(1, id);
					pstmt5.setString(1, id);
					int c = pstmt1.executeUpdate();
					int c2 = pstmt2.executeUpdate();
					int c3 = pstmt3.executeUpdate();
					int c4 = pstmt4.executeUpdate();
					int c5 = pstmt5.executeUpdate();
					System.out.println(c);
					System.out.println(c2);
					System.out.println(c3);
					System.out.println(c4);
					System.out.println(c5);
					con.commit();

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
		

	}

}
