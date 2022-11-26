<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Know Your Neighborhood</title>
<style type="text/css">
	label, input {
		display: block;
	}
</style>
</head>
<body>
	
	<a href="<%= request.getContextPath() %>/store">View Store</a>

	<form:form modelAttribute="store" action="saveAddStore" method="POST">
		<h1>Add Store</h1>
		<label>Store Name</label>
		<form:input type="text" path="name"/>
			
		<label>Phone Number</label>
		<form:input type="text" path="phone_number"/>

		<label>Localities</label>
		<form:input type="text" path="localities"/>
			
		<button type="submit">Submit</button>
	</form:form>
</body>
</html>