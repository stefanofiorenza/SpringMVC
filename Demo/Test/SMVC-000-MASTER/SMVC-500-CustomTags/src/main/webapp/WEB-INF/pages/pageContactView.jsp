<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h3>CRM JSTL DEMO</h3>
<h1>Single Contact:</h1>
<table>
	<tr>
		<td>Name:</td>
		<td>${cmdCommand.name}</td>				
	</tr>
	<tr>
		<td>Telephone:</td>				
		<td>${cmdCommand.telephone}</td>
	</tr>
	<tr>
		<td>Customer</td>
		<td>${cmdCommand.customer.name}</td>			
	</tr>	
	
	<tr>
		<td>Active</td>
		<td>
			<c:if test="${cmdCommand.active}">
				Active
			</c:if>
			<c:if test="${!cmdCommand.active}">
				Not Active
			</c:if>
		</td>			
	</tr>
	
	<tr>
		<td>Contact Type</td>
		<td>		
		<c:choose>  
		    <c:when test="${cmdCommand.type eq 'TECHNICAL'}">  
		      Technical  
		    </c:when>  
		    <c:when test="${cmdCommand.type eq 'BUSINESS'}">  
		        Business  
		    </c:when>  
		    <c:otherwise>  
		      Type is not defined  
		    </c:otherwise>  
		</c:choose>  
		</td>			
	</tr>	

	<tr>
		<td>Groups</td>
		<td>
			<select name="Group">				
				 <c:forEach items="${cmdCommand.groups}" var="group">
          			<option value="${group.id}">${group.name}</option>
         		</c:forEach>
			</select>
		</td>			
	</tr>		
</table>

<br/>
<br/>
<a href="${pageContext.request.contextPath}/main/index"> Back To Index</a><br/>		

</body>
</html>