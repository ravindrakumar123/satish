<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Registration Form</title>

<style>

	.error {
		color: #ff0000;
	}
</style>

</head>

<body>

	<h2>Registration Form</h2>
 
	<form:form method="POST"  modelAttribute="student">
		<form:input type="hidden" path="id" id="id"/>
		<table>
			<tr>
				<td>Name:</td>
				<td><form:input path="name" id="name"/></td>
				<td><form:errors path="name" cssClass="error"/></td>
		    </tr>
		    
		    <tr>
				<td>Father Name:</td>
				<td><form:input path="fatherName" id="fatherName"/></td>
				<td><form:errors path="fatherName" cssClass="error"/></td>
		    </tr>
		    
		    <tr>
				<td>Gender: </td>
				<td><form:input path="gender" id="gender"/></td>
				<td><form:errors path="gender" cssClass="error"/></td>
		    </tr>
		    
		    <tr>
				<td>Qualification:</td>
				<td><form:input path="qualification" id="qualification"/></td>
				<td><form:errors path="qualification" cssClass="error"/></td>
		    </tr>
		    
		    <tr>
				<td>Year:</td>
				<td><form:input path="year" id="year"/></td>
				<td><form:errors path="year" cssClass="error"/></td>
		    </tr>
		    
		    <tr>
				<td>Marks:</td>
				<td><form:input path="marks" id="marks"/></td>
				<td><form:errors path="marks" cssClass="error"/></td>
		    </tr>
		    
		    <tr>
				<td>Address:</td>
				<td height="150%"><form:input path="address" id="address"/></td>
				<td><form:errors path="address" cssClass="error"/></td>
		    </tr>
	    
			<tr>
				<td>Date Of Birth:</td>
				<td><form:input path="dateOfBirth" id="dateOfBirth"/></td>
				<td><form:errors path="dateOfBirth" cssClass="error"/></td>
		    </tr>
	
			<tr>
				<td>NUMBER:  </td>
				<td><form:input path="stuno" id="stuno"/></td>
				<td><form:errors path="stuno" cssClass="error"/></td>
		    </tr>
		    <tr>   </tr>  <tr> <td>  </td> </tr>
		   <!--  <tr>
                    <td>Select Your Photo:</td>
                    <td><input type="file" name="fileUpload" size="50" /></td>
                </tr>
                <tr>
                    <td>Select Your Sign:</td>
                    <td><input type="file" name="fileUpload" size="50" /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Upload" /></td>
                </tr> -->
	
			<tr>
				<td colspan="3">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update"/>
						</c:when>
						<c:otherwise>
							<input type="submit" value="Register"/>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</table>
	</form:form>
	<br/>
	<br/>
	Go back to:     <a href="<c:url value='/app/list' />">"List of All CANDIDATES"</a>
</body>
</html>