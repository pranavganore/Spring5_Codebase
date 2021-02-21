<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
<meta charset="UTF-8">
<title>Student Registration Form</title>
</head>

<body>

	<form:form action="processForm" modelAttribute="student">
	
		First Name: <form:input path="firstName"/>
	
			<br><br>
	
		Last Name : <form:input path="lastName"/>

		
		<br><br>
		Country of Residency : 
		<form:select path="country_residency">
		<!-- 
			<form:option value="IND" label="India"/>
			<form:option value="USA" label="America"/>
			<form:option value="FRA" label="France"/>
			<form:option value="AUS" label="Australia"/>
			<form:option value="CAN" label="Canada"/> 
			-->
		<!-- You can either add options statistically in html like above
				OR
			From a Java code as shown in Student.java (line 17-30) -->
		<form:options items="${student.res_countryOptions}"/>	
		
		</form:select>
		
		<br><br>
		
		Country of Citizenship : 
		<form:select path="country_citizenship">
			
			<!-- 
			<form:option value="IND" label="India"/>
			<form:option value="USA" label="America"/>
			<form:option value="FRA" label="France"/>
			<form:option value="AUS" label="Australia"/>
			<form:option value="CAN" label="Canada"/> 
			-->
			<!-- You can either add options statistically in html like above
					OR
				From a properties file as shown below (for details refer to slide 134 UDEMY ChadDarby) -->
			<form:options items="${theCountryOptions}"/>
			
		</form:select>
		
		<br><br>
		
		Favorite Language :
		Java <form:radiobutton path="favLanguage" value="Java"/>
		C++ <form:radiobutton path="favLanguage" value="C++"/>
		PHP <form:radiobutton path="favLanguage" value="PHP"/>
		Ruby <form:radiobutton path="favLanguage" value="Ruby"/>
		
		
		<br><br>
		
		Operating Systems :
		Linux <form:checkbox path="OS" value="Linux"/>
		Mac OS <form:checkbox path="OS" value="Mac OS"/>
		MS Windows <form:checkbox path="OS" value="MS Wondows"/>
			
		<br><br>
		
		
		<input type="submit" value="submit"/>
	
	</form:form>

</body>
</html>