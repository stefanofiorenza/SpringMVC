<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sform"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<c:set var = "UserControllerUri" value = "${pageContext.request.contextPath}/forms/users/v3"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h3>SESSION DEMO: INDEX</h3>
<sform:form method="POST" commandName="userFormSession" action="${UserControllerUri}/step2" >
		<table>
			<tr>
				<td>Name:</td>
				<td><sform:input path="name" /></td>				
			</tr>
			<tr>
				<td>Email:</td>
				<td><sform:input path="email" /></td>				
			</tr>
			<tr>
				<td>Address:</td>
				<td><sform:input path="address" /></td>				
			</tr>
			<tr>
				<td>Gender:</td>
				<td><sform:select path="gender">
						<sform:option value="" label="Select Gender" />
						<sform:option value="M" label="Male" />
						<sform:option value="F" label="Female" />
					</sform:select></td>
				<td>&nbsp;</td>
			</tr>			
			<tr>
				<td colspan="2"><input type="submit" value="Next"></td>
			</tr>
		</table>

	</sform:form>
	
	
	
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