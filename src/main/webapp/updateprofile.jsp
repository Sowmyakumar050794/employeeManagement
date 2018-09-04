<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="./updateEmployee" method="get">
		<fieldset title="Search">
			<legend><B>Update Employee Info</B></legend>
			<BR/>
			<table height="60%">
			<tr>
			<td>Emp_Id  </td>
				<td><input type="text" name="eid" placeholder="Insert  Emp Id"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit"/></td>
				<td><input type="Submit" value="Reset"/></td>
			</tr>

</body>
</html>