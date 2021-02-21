<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Customer Confirmation</title>
</head>

<body>

	The Customer is CONFIRMED : ${customer.firstName} ${customer.lastName}
	<br><br>
	Free Passes : ${customer.freePasses}
	<br><br>
	Postal Code : ${customer.postalCode}
	<br><br>
	Course Code : ${customer.courseCode}

</body>
</html>