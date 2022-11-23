<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Store</title>
<style type="text/css">
	label, input {
		display: block;
		margin-bottom: 8px;
	}
</style>
</head>
<body>
	<form:form action="stores" method="post" modelAttribute="store">
		<label>Name</label>
		<form:input path="name" type="text" />
		
		<label>Phone Number</label>
		<form:input path="phone_number" type="text" />
		
		<label>Localities</label>
		<form:input path="localities" type="text" />
		
		<input type="submit" value="Submit">
	</form:form>
</body>
</html>