<%@page import="com.teamsankya.employeemanagement.dto.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
	EmployeeBean bean = (EmployeeBean)request.getAttribute("bean");
%>
<body>
<%if(bean!=null) {%>
	<table>
	 <tr bgcolor=\"green\">>
			<td>Eid</td>
			<td>Fname</td>
			<td>Lname</td>
			<td>Address1</td>
			<td>Address2</td>
			<td>City</td>
			<td>Pincode</td>
			<td>Email</td>
			<td>Ph No.</td>
			<td>DOB</td>
			<td>Experience</td>
			<td>last company name</td>
			<td>designation</td>
			<td>Date of join</td>
			<td>CTC</td>	
		</tr>
		<tr>
			<td><%=bean.getBasic().getId() %></td>
			<td><%=bean.getBasic().getFname() %></td>
			<td><%=bean.getBasic().getLname() %></td>
			<td><%=bean.getAddr().getAddr1() %></td>
			<td><%=bean.getAddr().getAddr2() %></td>
			<td><%=bean.getAddr().getCity() %></td>
			<td><%=bean.getAddr().getPincode() %></td>
			<td><%=bean.getPersonal().getEmail() %></td>
			<td><%=bean.getPersonal().getCellNo() %></td>
			<td><%=bean.getPersonal().getDob() %></td>
			<td><%=bean.getLstcmp().getExp() %></td>
			<td><%=bean.getLstcmp().getLastComp() %></td>
			<td><%=bean.getComp().getDesignation() %></td>
			<td><%=bean.getComp().getDoj() %></td>
			<td><%=bean.getComp().getCtc() %></td>
		</tr>
	</table>
	<%}else { %>
	<h1>Employee  does not exist</h1>
	<%} %>
	<a href='./searchprofile.jsp'>Click here to search an employee</a>
</body>
</html>