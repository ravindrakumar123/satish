<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>View Details</title>

	<style>
		tr:first-child{
			font-weight: bold;
			background-color: #C6C9C4;
		}
	</style>

</head>


<body>
	<h2>List of Students Details</h2>	
	<table border="3">
		<tr>
			<td>NAME  </td><td>FATHER NAME</td><td>GENDER  </td><td>ADDRESS  </td><td>Date Of Birth  </td><td>QUALIFICATION  </td><td>YEAR  </td><td>MARKS  </td><td>STUDENT NO </td><td>Action </td><td>
		</tr>
		<c:forEach items="${students}" var="student">
			<tr>
			<td>${student.name}</td>
			<td>${student.fatherName}</td>
			<td>${student.gender}</td>
			<td>${student.address}</td>
			<td>${student.dateOfBirth}</td>
			<td>${student.qualification}</td>
			<td>${student.year}</td>
			<td>${student.marks}</td>
			<td>${student.stuno}</td>
			<td><a href="<c:url value='/app/edit-${student.stuno}-student' />">Edit</a></td>
		 <td><a href="<c:url value='/app/delete-${student.stuno}-student' />">Delete</a></td> 
			<%-- <td>${student.fileName}</td>
			<td>${student.data}</td> --%>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/app/new'/>">Add New Student Resume</a>
</body>
</html>