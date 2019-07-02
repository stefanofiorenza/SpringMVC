<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sform"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:set var = "UserControllerUri" value = "${pageContext.request.contextPath}/form"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

Message:<span>Messaggio: ${msg}</span>

<h3>FORM DEMO</h3>
<sform:form method="POST" commandName="userForm" action="${UserControllerUri}/save" >
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
				<td colspan="2"><input type="submit" value="Save User"></td>
			</tr>
		</table>

	</sform:form>
	
</body>
</html>