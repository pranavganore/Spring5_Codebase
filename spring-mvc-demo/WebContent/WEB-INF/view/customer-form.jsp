<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
<meta charset="UTF-8">

	<title>Customer Registration Form</title>
	<style>
		.error	{color:red}
	</style>
</head>

<body>

Fillout the form.
Asterisk (*) indicates required / mandatory fields.

	<form:form action="processForm" modelAttribute="customer">
	
		First name: <form:input path="firstName"/>
		
		<br><b>
		
		Last name(*): <form:input path="lastName"/>
		
		<!-- Form validation : Display the error message on HTML form  -->
		<form:errors path="lastName" cssClass="error"/>
		
		<br><br>
						
		Free Passes: <form:input path="freePasses"/>
		
		<!-- Form validation : Display the error message on HTML form  -->
		<form:errors path="freePasses" cssClass="error"/>
		
		<br><br>
						
		Postal Code: <form:input path="postalCode"/>
		
		<!-- Form validation : Display the error message on HTML form  -->
		<form:errors path="postalCode" cssClass="error"/>
		
		<br><br>
						
		Course Code: <form:input path="courseCode"/>
		
		<!-- Custom validation : Display the error message on HTML form  -->
		<form:errors path="courseCode" cssClass="error"/>
	
		<br><br>
		<input type="submit" value="submit" />
	</form:form>
</body>


</html>
