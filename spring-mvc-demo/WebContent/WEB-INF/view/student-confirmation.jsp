<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	<!-- This is reference JSTL tag library -->

<!DOCTYPE html>

<html>

<head>
<meta charset="UTF-8">
<title>Student Confirmation</title>
</head>

<body>

The Student is confirmed :	${student.firstName} ${student.lastName}
<br>
Country of Citizenship : ${student.country_citizenship}
<br>
Country Of Residence : ${student.country_residency}
<br>
Favorite Language    : ${student.favLanguage}
<br><br>

Operating Systems : 
<!-- adding the loop to display bullet list using the JSTL (added in the libtag above) -->
<ul>
	<c:forEach var="temp" items="${student.OS}">
		<li> ${temp} </li>
		
	</c:forEach>
	
</ul>


</body>
</html>