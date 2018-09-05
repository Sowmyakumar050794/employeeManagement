<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="./get?search=" method="post">
		<fieldset title="Search">
			<legend><B>Search By Employee Info</B></legend>
			<BR/>
			<table height="60%">
			<tr>
				<td>Search Employee  </td>
				<td><input type="text" name="keyword" placeholder="search here"/></td>
			</tr>
			
				<!-- <td><B>NOTE:</B>  </td>
				<td><B><U><I><font color="red"> Search Employee Details any one field </font></B></U></I></td> -->
			</tr>
			<tr></tr><tr></tr><tr></tr>
			<tr>
				<td><input type="submit" value="Search "/></td>
				<td><input type="reset" value="Reset"/></td>
			</tr>
		</table>
			
		
		</fieldset>
	</form>

</body>
</html>