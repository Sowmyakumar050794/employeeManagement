<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<fieldset title="Search">
		<legend>
			<B>Delete Employee Info</B>
		</legend>
		<BR />
		<form action="./delete" method="post">
			<table height="60%">
				<tr>
					<td>EmployeeId</td>
					<td><input type="text" name="eid" placeholder="Insert  Emp Id" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Delete" /></td>
					<td><input type="reset" value="Reset" /></td>
				</tr>
			</table>
		</form>
	</fieldset>
</body>
</html>