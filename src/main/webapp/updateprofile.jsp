<%@page import="com.teamsankya.employeemanagement.dto.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="./header.css">
</head>
<body>
<html>
<%
EmployeeBean bean = (EmployeeBean) request.getAttribute("bean");
%>
<body>
<div class="border">
<form action="./update" method="post">
<table width="800">
<tr>
<td>
<fieldset>
<legend>
<B>Employee Basic Info ...</B>
</legend>
<table width="500">
<tr>
<td>Employee Id</td>
<td><input type="text" id="eid" name="eid"
value="<%=bean.getBasic().getId()%>"></td>
</tr>
<tr>
<td>First Name</td>
<td><input type="text" name="fname" ="<%=bean.getBasic().getFname()
%>" required="required" /></td>
</tr>
<tr>
<td>Last Name</td>
<td><input type="text" name="lname"
placeholder="<%=bean.getBasic().getLname() %>" required="required" /></td>
</tr>
</table>
</fieldset>
</td>
</tr>

<tr>
<td>
<fieldset>
<legend>
<B>Employee Personal Info ...</B>
</legend>
<table width="500">
<tr>
<td>Contact Number</td>
<td><input type="number" name="mob_num"
placeholder="<%=bean.getPersonal().getCellNo() %>" required="required" /></td>
</tr>
<tr>
<td>Email</td>
<td><input type="email" name="email"
placeholder="<%=bean.getPersonal().getEmail() %>" required="required" /></td>
</tr>
<tr>
<td>Date Of Birth</td>
<td><input type="date" name="DOB"
placeholder="<%=bean.getPersonal().getDob() %>" required="required" /></td>
</tr>
</table>
</fieldset>
</td>
</tr>

<tr>
<td>
<fieldset>
<legend>
<B>Last JOB Related Info ...</B>
</legend>
<table width="500">
<tr>
<td>Last Company Name</td>
<td><input type="text" name="last_comp"
placeholder="<%=bean.getLstcmp().getLastComp() %>" /></td>
</tr>
<tr>
<td>Experience</td>
<td><input type="text" name="exp"
placeholder="<%=bean.getLstcmp().getExp() %>" /></td>
</tr>
</table>
</fieldset>
</td>
</tr>
<tr>
<td>
<fieldset>
<legend>
<B>Present Company Info ...</B>
</legend>
<table width="500">
<tr>
<td>Date of Join</td>
<td><input type="date" name="date_of_join"
placeholder="<%=bean.getComp().getDoj() %>" required="required" /></td>
</tr>
<tr>
<td>Designation</td>
<td><input type="text" name="designation"
placeholder="<%=bean.getComp().getDesignation() %>" required="required" /></td>
</tr>
<tr>
<td>CTC</td>
<td><input type="number" name="CTC"
placeholder="<%=bean.getComp().getCtc() %>" required="required" /></td>
</tr>
</table>
</fieldset>
</td>
</tr>

<tr>
<td>
<fieldset>
<legend>
<B> Employee Address Info ...</B>
</legend>
<table width="500">
<tr>
<td>Address 1</td>
<td><input type="text" name="addr1"
placeholder="<%=bean.getAddr().getAddr1() %>" required="required" /></td>
</tr>
<tr>
<td>Address 2</td>
<td><input type="text" name="addr2"
placeholder="<%=bean.getAddr().getAddr2() %>" required="required" /></td>
</tr>
<tr>
<td>City</td>
<td><input type="text" name="city"
placeholder="<%=bean.getAddr().getCity() %>" required="required" /></td>
</tr>
<tr>
<td>Pin Code</td>
<td><input type="number" name="pincode"
placeholder="<%=bean.getAddr().getPincode() %>" /></td>
</tr>
</table>
</fieldset>
</td>
</tr>
</table>
<BR> <input type="reset" value="Reset" />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit"
value="Update Profile" />

</form>
</div>
</body>
</html>



</body>
</html>
