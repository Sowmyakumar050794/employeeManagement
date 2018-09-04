<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    <%@page import="java.util.Date" %>
    <%
    Date dateref= new Date();
    String currentdate=dateref.toString();
    %>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="./header.css">
</head>
<body>
<div class="border">
           <div style="margin:0px;padding-bottom:0px;" id="div">
			<ul style="list-style: none">
				<li><font class="color">Welcome To Employee Management System </font></li>
				<li><span class="highlight"><%=currentdate %></span></li>
				</li>
			</ul>
		</div>
		<br>
		<br>
		<div class="header" align="left" id="top">
		     <ul class="topnav"  style="list-style: none">
				
				<li><a href="./searchprofile.jsp" class="a" id="font" position="center">Seach Profile</a></li>
				<li><a href="./updateprofile.jsp" class="a" id="font" position="center">Update Profile</a></li>
				<li><a href="./deleteprofile.jsp" class="a" id="font" position="center">Delete Profile</a></li>
			</ul> 
	</div>
	<div class="footer1" id="top">
		<ul class="topnav">
			<marquee class="b" id="font"> 
				&copy;2018 All Rights Reserved.
			</marquee>
		</ul>
	</div>
	</div>
</body>
</html>