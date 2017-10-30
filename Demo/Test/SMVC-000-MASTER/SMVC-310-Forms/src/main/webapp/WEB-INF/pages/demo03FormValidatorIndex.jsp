<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sform"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<c:set var = "UserControllerUri" value = "${pageContext.request.contextPath}/forms/users/v2"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
    .error {
        color: red; font-weight: bold;
    }
</style>

</head>
<body>
<h3>FORM VALIDATION DEMO</h3>

<sform:form method="POST" commandName="userForm" action="${UserControllerUri}/save" >
		<table>
			<tr>
				<td>Name:</td>
				<td><sform:input path="name" /></td>
				<td align="left"><sform:errors path="name" cssClass="error"/></td>				
			</tr>
			<tr>
				<td>Email:</td>
				<td><sform:input path="email" /></td>
				<td align="left"><sform:errors path="email" cssClass="error"/></td>					
			</tr>
			<tr>
				<td>Address:</td>
				<td><sform:input path="address" /></td>	
				<td align="left"><sform:errors path="address" cssClass="error"/></td>				
			</tr>
			<tr>
				<td>Gender:</td>
				<td><sform:select path="gender">
						<sform:option value="" label="Select Gender" />
						<sform:option value="M" label="Male" />
						<sform:option value="F" label="Female" />
					</sform:select></td>
				<td align="left"><sform:errors path="address" cssClass="error"/></td>	
			</tr>			
			<tr>
				<td colspan="3"><input type="submit" value="Save User"></td>
			</tr>
		</table>

	</sform:form>
	
</body>
</html>