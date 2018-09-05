package com.teamsankya.employeemanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import com.teamsankya.employeemanagement.dto.EmpAddrInfo;
import com.teamsankya.employeemanagement.dto.EmpBasicInfo;
import com.teamsankya.employeemanagement.dto.EmpCompInfo;
import com.teamsankya.employeemanagement.dto.EmpLstCmpInfo;
import com.teamsankya.employeemanagement.dto.EmpPersonalInfo;
import com.teamsankya.employeemanagement.dto.EmployeeBean;

public class EmpMngmtDaoJDBCImpl implements EmployeeManagementDAO {

	
	@Override
	public boolean createEmployee(EmployeeBean bean) {
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

		EmpBasicInfo info = new EmpBasicInfo();
		EmpAddrInfo addr = new EmpAddrInfo();
		EmpCompInfo comp = new EmpCompInfo();
		EmpLstCmpInfo last = new EmpLstCmpInfo();
		EmpPersonalInfo per = new EmpPersonalInfo();
		EmployeeBean bean = new EmployeeBean();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			try (Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/employee_management?user=root&password=root");
					PreparedStatement pstmt1 = con
							.prepareStatement("SELECT * FROM employeebasic_info ebi, employeeaddress_info eai, \r\n"
									+ "employeepersonal_info epi, employeelastcompany_info elci,\r\n"
									+ " employeecompany_info eci WHERE ebi.eid=eai.eid AND eai.eid=epi.eid AND epi.eid=elci.eid\r\n"
									+ " AND elci.eid=eci.eid AND eci.eid= ?");) {
				pstmt1.setString(1, id);
				try (ResultSet rs = pstmt1.executeQuery()) {
					if (rs.next()) {
						System.out.println("Employee found");
						info.setFname(rs.getString("fname"));
						info.setId(id);
						info.setLname(rs.getString("fname"));

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
				}}
			

			} catch (Exception e) {
				e.printStackTrace();
			}
		return null;
			
		}

		
	@Override
		public EmployeeBean updateData(String id, EmployeeBean bean) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager
						.getConnection("jdbc:mysql://localhost:3306/employee_management?user=root&password=root");
						PreparedStatement pstmt1 = con.prepareStatement("UPDATE employeebasic_info SET FNAME=?,LNAME=? WHERE EID=?");
						PreparedStatement pstmt2 = con.prepareStatement("UPDATE employeeaddress_info SET ADDR1=?,ADDR2=?,CITY=?,PINCODE=? WHERE EID=?");
						PreparedStatement pstmt3 = con.prepareStatement("UPDATE employeepersonal_info SET EMAIL=?,MOB_NUM=?,DOB=? WHERE EID=?");
						PreparedStatement pstmt4 = con.prepareStatement("UPDATE employeelastcompany_info SET EXP=?,LAST_COMP=? WHERE EID=?");
						PreparedStatement pstmt5 = con.prepareStatement("UPDATE employeecompany_info SET DESIGNATION=?,DATE_OF_JOIN=?,CTC=? WHERE EID=?");) 
				{

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

				}
			}
	
				catch(Exception e)
				{
					e.printStackTrace();
				}
			return bean;
			}

					

			
		

	@Override
	public boolean deleteEmployee(String id) {
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

	@Override
	public String getEid(String input) {
		String eid=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try (Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/employee_management?user=root&password=root")) {
				con.setAutoCommit(false);
				try (PreparedStatement pstmt1 = con
						.prepareStatement("  select pi.eid from employeebasic_info bi, employeepersonal_info pi,employeecompany_info ci where \r\n" + 
								"bi.fname=? or bi.lname=? or bi.eid=?\r\n" + 
								" or pi.email=? or pi.mob_num=? or pi.eid=?\r\n" + 
								"  or ci.designation=? or ci.eid=?\r\n" + 
								" ; ");
						/*PreparedStatement pstmt2 = con
								.prepareStatement("select eid from employeepersonal_info where email=? or mob_num=? ");
						PreparedStatement pstmt3 = con
								.prepareStatement("select eid from employeecompany_info where designation=? ");*/) {
					pstmt1.setString(1, input);
					pstmt1.setString(2, input);
					pstmt1.setString(3, input);
					pstmt1.setString(4, input);
					pstmt1.setString(5, input);
					pstmt1.setString(6, input);
					pstmt1.setString(7, input);
					pstmt1.setString(8, input);
					/*pstmt2.setString(1, input);
					pstmt2.setString(2, input);
					pstmt3.setString(1, input);*/

					try (ResultSet rs1 = pstmt1.executeQuery();
							/*ResultSet rs2 = pstmt2.executeQuery();
							ResultSet rs3 = pstmt3.executeQuery()*/) {
						if (rs1.next()) {
							eid = rs1.getString("eid");
							System.out.println(eid);
							
						} /*else if (rs2.next()) {
							eid = rs2.getString("eid");
							System.out.println(eid);
							return eid;
						} else if (rs3.next()) {
							eid = rs3.getString("eid");
							System.out.println(eid);
							return eid;

						}*/ else {
							return null;
						}

					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} /*finally {

		}*/
		return eid;
	}
	
}
