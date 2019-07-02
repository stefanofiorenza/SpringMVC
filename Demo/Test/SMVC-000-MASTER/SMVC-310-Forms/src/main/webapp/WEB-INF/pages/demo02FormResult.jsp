<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<c:set var = "formMainControllerPath" value = "${pageContext.request.contextPath}/forms/main"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h3>FORM DEMO</h3>
	<h3> Users data Saved</h3>
	<table>
			<tr>
				<td>Name:</td>
				<td>${userForm.name}</td>				
			</tr>
			<tr>
				<td>Email:</td>				
				<td>${userForm.email}</td>
			</tr>
			<tr>
				<td>Address</td>
				<td>${userForm.address}</td>			
			</tr>
			<tr>
				<td>Gender:</td>
				<td>${userForm.gender}</td>				
			</tr>			
		</table>

		<br/>
		<br/>
		<a href="${formMainControllerPath}/index">MainMenu</a>

</body>
</html>