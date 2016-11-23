<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Success</title>
</head>
<body>
	<div align="center">
		<table border="0">
			<tr>
				<td colspan="2" align="center"><h2>Registration Succeeded!</h2></td>
			</tr>
			
			<tr>
				<td>Name:</td>
				<td>${userForm.name}</td>
			</tr>
			
			<tr>
				<td>Father name:</td>
				<td>${userForm.father name}</td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td>${userForm.gender}</td>
			</tr>
			
			<tr>
				<td>Date of Birth:</td>
				<td>${userForm.Date of Birth}</td>
			</tr>
			<tr>
				<td>Mobile</td>
				<td>${userForm.Mobile}</td>
			</tr>
			<tr>
				<td>E-mail:</td>
				<td>${userForm.email}</td>
			</tr>
			
			<tr>
				<td>Address</td>
				<td>${userForm.address}</td>
			</tr>
			
			
		</table>
	</div>
</body>
</html>