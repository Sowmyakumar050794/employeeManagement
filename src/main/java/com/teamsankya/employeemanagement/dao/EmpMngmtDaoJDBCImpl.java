package com.teamsankya.employeemanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import com.teamsankya.employeemanagement.dto.EmployeeBean;

public class EmpMngmtDaoJDBCImpl implements EmployeeManagementDAO{

	@Override
	public void createEmployee(EmployeeBean bean) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try (Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/employee_management?user=root&password=root");
					PreparedStatement pstmt1 = con.prepareStatement("INSERT INTO employeebasic_info VALUES(?,?,?)");
					PreparedStatement pstmt2 = con.prepareStatement("INSERT INTO employeeaddress_info VALUES(?,?,?,?,?)");
					PreparedStatement pstmt3 = con.prepareStatement("INSERT INTO employeepersonal_info VALUES(?,?,?,?)");
					PreparedStatement pstmt4 = con.prepareStatement("INSERT INTO employeelastcompany_info VALUES(?,?,?)");
					PreparedStatement pstmt5 = con.prepareStatement("INSERT INTO employeecompany_info VALUES(?,?,?,?)");) 
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
								
				
				
				boolean p1=pstmt1.execute();
				boolean p2=pstmt2.execute();
				boolean p3=pstmt3.execute();
				boolean p4=pstmt4.execute();
				boolean p5=pstmt5.execute();
				System.out.println(p1+" "+p2+" "+p3+" "+p4+" "+p5);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}







	}

	@Override
	public EmployeeBean getEmployee(String id) {
		
		return null;
	}

	@Override
	public EmployeeBean updateData(String id, EmployeeBean bean) {
		
		return null;
	}

	@Override
	public void deleteEmployee(String id) {
		

	}

}
