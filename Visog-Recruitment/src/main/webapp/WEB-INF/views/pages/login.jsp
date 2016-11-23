<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Form</title>
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
				<td>Password:</td>
				<td><form:input path="password" id="ssn"/></td>
				<td><form:errors path="password" cssClass="error"/></td>
		    </tr>
		    
		    <tr>
		    
				<td>		<c:otherwise>
							<input type="submit" value="Login"/>
						</c:otherwise>
					</td>			
			</tr>
		</table>
	</form:form>


</body>
</html>