<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
  
     <c:if test="${message ne null}">
       <c:out value="${message}"/>
     </c:if>
     <br>
     <form action="upload.html" method="POST" enctype="multipart/form-data">
        select a file <input type="file" name="file1"> <br>
        <input type="submit" value="UPLOAD">
     </form>
</body>
</html>