<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Confirmation Page</title>
</head>
<body>
	Message : ${success}
	<br/>
	Now you can <a href="<c:url value='/app/list'/>">All Students</a>
	<br/>
	<!--  Go back to <a href="<c:url value='/app/list' />">List of All Employees</a> <br><br> -->
	
	
</body>

</html>