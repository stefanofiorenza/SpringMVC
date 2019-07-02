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

	<h3>SESSION DEMO</h3>
	<h3> Users data Saved</h3>
	<table>
			<tr>
				<td>Name:</td>
				<td>${userFormSession.name}</td>				
			</tr>
			<tr>
				<td>Email:</td>				
				<td>${userFormSession.email}</td>
			</tr>
			<tr>
				<td>Address</td>
				<td>${userFormSession.address}</td>			
			</tr>
			<tr>
				<td>Gender:</td>
				<td>${userFormSession.gender}</td>				
			</tr>	
			<tr>
				<td>Password:</td>
				<td>${userFormSession.password}</td>				
			</tr>	
			<tr>
				<td>Newsletter:</td>
				<td>${userFormSession.newsletter}</td>				
			</tr>
			<tr>
				<td>number:</td>
				<td>${userFormSession.number}</td>				
			</tr>			
		</table>

		<br/>
		<br/>
		<a href="${formMainControllerPath}/index">MainMenu</a>


<hr />
<h3>Request Scope (key==values)</h3>
<%
	java.util.Enumeration<String> reqEnum = request.getAttributeNames();
	while (reqEnum.hasMoreElements()) {
		String s = reqEnum.nextElement();
		out.print(s);
		out.println("==" + request.getAttribute(s));
		out.println("<br />");
	}
%>

<h3>Session Scope (key==values)</h3>
<%
	java.util.Enumeration<String> sessionEnum = session.getAttributeNames();
	while (sessionEnum.hasMoreElements()) {
		String s = sessionEnum.nextElement();
		out.print(s);
		out.println("==" + session.getAttribute(s));
		out.println("<br />");
	}
%>
</body>
</html>