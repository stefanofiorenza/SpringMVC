<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sform"%>
<html>
<head>
<c:set var ="ContactControllerUri" value = "${pageContext.request.contextPath}/contacts"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h3>CRM JSTL FORM DEMO</h3>
<h1>Save New Contact:</h1>
<sform:form method="POST" commandName="cmdCommand" action="${ContactControllerUri}/save" >
<table>
	<tr>
		<td>Name:</td>
		<td><sform:input path="name" /></td>				
	</tr>
	<tr>
		<td>Telephone:</td>				
		<td><sform:input path="telephone" /></td>
	</tr>
	<tr>
		<td>Customer</td>
		<td><sform:input path="customer.name" /></td>			
	</tr>	
	<tr>
		<td>Selected Group</td>
		<td><ul>
				<sform:radiobuttons path="groupSelected" items="${groups}" element="li" />				
			</ul>
		</td>			
	</tr>
	<tr>
		<td>Active</td>
		<td>			
			<sform:radiobutton path="active" value="true" /> Active	<br/>
			<sform:radiobutton path="active" value="false"/>Deactivated	<br/>		
		</td>			
	</tr>
	
	<tr>
		<td>Contact Type</td>
		<td>	
			<sform:select path="type">
				<sform:option value="TECHNICAL">Technical</sform:option>
				<sform:option value="BUSINESS">Business</sform:option>
				<sform:option value="USER">User</sform:option>
			</sform:select>			
		</td>			
	</tr>		
	<tr>
		<td><input type="reset" value="Cancel"/></td>
		<td><input type="submit" value="Submit"/></td>
	</tr>
</table>
</sform:form>


<br/>
<br/>
<a href="${pageContext.request.contextPath}/main/index"> Back To Index</a><br/>		

</body>
</html>