<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="./header.css">
</head>
<body>
<html>
<body>
<div class="border">
	<form action="./create" method="post">
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
								<td><input type="text" name="eid" placeholder="Enter emp id" required="required" /></td>
							<tr>
								<td>First Name</td>
								<td><input type="text" name="fname" placeholder="Enter first name" required="required" /></td>
							</tr>
							<tr>
								<td>Last Name</td>
								<td><input type="text" name="lname" placeholder="Enter last name" required="required" /></td>
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
								<td><input type="number" name="mob_num" placeholder="Enter Mobile Number" required="required" /></td>
							</tr>
							<tr>
								<td>Email</td>
								<td><input type="email" name="email" placeholder="Enter E-Mail Address" required="required" /></td>
							</tr>
							<tr>
								<td>Date Of Birth</td>
								<td><input type="date" name="DOB" placeholder="Enter date of birth" required="required" /></td>
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
								<td><input type="text" name="last_comp" placeholder="Enter Last company Name"  /></td>
							</tr>
							<tr>
								<td>Experience</td>
								<td><input type="text" name="exp" placeholder="Enter experience"  /></td>
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
								<td><input type="date" name="date_of_join" placeholder="Enter date of join" required="required" /></td>
							</tr>
							<tr>
								<td>Designation</td>
								<td><input type="text" name="designation" placeholder="Enter designation" required="required" /></td>
							</tr>
							<tr>
								<td>CTC</td>
								<td><input type="number" name="CTC" placeholder="Enter salary" required="required" /></td>
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
								<td><input type="text" name="addr1" placeholder="Enter Address1" required="required" /></td>
							</tr>
							<tr>
								<td>Address 2</td>
								<td><input type="text" name="addr2" placeholder="Enter Address2" required="required" /></td>
							</tr>
							<tr>
								<td>City</td>
								<td><input type="text" name="city" placeholder="Enter city" required="required" /></td>
							</tr>
							<tr>
								<td>Pin Code</td>
								<td><input type="number" name="pincode" placeholder="Enter pincode"  /></td>
							</tr>
						</table>
					</fieldset>
				</td>
			</tr>
		</table>
		<BR>
		<input type="reset" value="Reset" />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" value="Create Profile" /> 

	</form>
	</div>
</body>
</html>
						
							

</body>
</html>