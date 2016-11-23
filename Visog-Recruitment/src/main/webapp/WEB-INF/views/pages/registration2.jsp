<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Form</title>
</head>
<body>
	<form:form method="POST"  modelAttribute="employee">
		<form:input type="hidden" path="id" id="id"/>
		<table>
			<tr>
				<td>Name:</td>
				<td><form:input path="name" id="name"/></td>
				<td><form:errors path="name" cssClass="error"/></td>
		    </tr>
		    
		    <tr>
				<td>Father Name:</td>
				<td><form:input path="fname" id="fname"/></td>
				<td><form:errors path="fname" cssClass="error"/></td>
		    </tr>
		    
		    <tr>
				<td>Gender: </td>
				<td><form:input path="gender" id="gender"/></td>
				<td><form:errors path="gender" cssClass="error"/></td>
		    </tr>
		    
		    <tr>
				<td>Date Of Birth:</td>
				<td><form:input path="dateOfBirth" id="dateOfBirth"/></td>
				<td><form:errors path="dateOfBirth" cssClass="error"/></td>
		    </tr>
	
		    
		    <tr>
				<td>Mobile</td>
				<td><form:input path="mobile" id="mobile"/></td>
				<td><form:errors path="mobile" cssClass="error"/></td>
		    </tr>
		    
		    <tr>
				<td>Email</td>
				<td><form:input path="email" id="email"/></td>
				<td><form:errors path="email" cssClass="error"/></td>
		    </tr>
		    
		    <tr>
				<td>Password:</td>
				<td><form:input path="password" id="password"/></td>
				<td><form:errors path="password" cssClass="error"/></td>
		    </tr>
		    <tr>
				<td>Address:</td>
				<td><form:input path="address" id="address"/></td>
				<td><form:errors path="address" cssClass="error"/></td>
		    </tr>
	    
			
			<tr>
		    
				<td>		<c:otherwise>
							<input type="submit" value="Register"/>
						</c:otherwise>
					</td>			
			</tr>
		</table>
	</form:form>
</body>
</html>