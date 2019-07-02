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

<h3>SESSION DEMO: STEP 1</h3>
<sform:form method="POST" commandName="userFormSession" action="${UserControllerUri}/step3" >
		<table>
			<tr>
				<td>Password:</td>
				<td><sform:input path="password" /></td>				
			</tr>
			<tr>
				<td>RepeatPassword:</td>
				<td><sform:input path="confirmPassword" /></td>				
			</tr>		
			<tr>
				<td>Newsletter:</td>
				<td><sform:select path="newsletter">
						<sform:option value="true" label="Yes" />
						<sform:option value="false" label="No" />
					</sform:select></td>				
			</tr>	
				<tr>
				<td>Skills:</td>				
				<td>
					<sform:select path="skill" items="${skillsList}" multiple="true" />
				</td>							
			</tr>	
			<tr>
				<td>number:</td>
				<td>
					1<sform:radiobutton path="number" value="1" /> <br/>
					2<sform:radiobutton path="number" value="2" /> <br/>
					3<sform:radiobutton path="number" value="3" /> <br/>
					4<sform:radiobutton path="number" value="4" /> <br/>
					5<sform:radiobutton path="number" value="5" /> <br/>				
				</td>				
			</tr>
					
			<tr>
				<td colspan="2"><input type="submit" value="Save"></td>
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