<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- PAGINATION MANAGEMENT -->
		<c:set var="contacts" scope="session" value="${contactsFound}"/>
		<c:set var="totalCount" scope="session" value="${contactsFound.size()}"/>
		<c:set var="perPage" scope="session"  value="10"/>
		<c:set var="pageStart" value="${param.start}"/>
	
		<!-- Handler max e min Page -->
			<!--  PageStart default for lower than 0 or missing -->
			<c:if test="${empty pageStart or pageStart < 0}">
		       <c:set var="pageStart" value="0"/>
			</c:if>
			<!--  PageStart not higher than total -->
			<c:if test="${totalCount < pageStart}">
		       <c:set var="pageStart" value="${pageStart - 10}"/>
			</c:if>
		
		<!-- Change Start Page (Parameter {param.start}) -->
		<a href="?start=${pageStart - 10}">Previous</a>Page: ${pageStart + 1} - ${pageStart + 10} 
    	<a href="?start=${pageStart + 10}">Next</a>     


<h3>CRM JSTL DEMO TABLE</h3>
<h1>Contacts:</h1>
<table style="width:1200px;"}>
	<tr>
		<th>Name:</th>
		<th>Telephone:</th>	
		<th>Customer</th>
		<th>Active</th>
		<th>Contact Type</th>
		<th>Group Names</th>
	</tr>
	
	<!-- WIth Pagination -->
		 <%--
		 <c:forEach items="${contactsFound}" var="contact" varStatus="contactCounter"
	           begin="${pageStart}" end="${pageStart + perPage - 1}">	 	
	     --%> 
	     
	     
	<%-- WITHOUT Pagination
	    <c:forEach items="${contactsFound}" var="contact">
	     --%>
	    <c:forEach items="${contactsFound}" var="contact" varStatus="contactCounter"
	           begin="${pageStart}" end="${pageStart + perPage - 1}">	 
		 <tr>		
			<td>${contact.name}</td>	
			<td>${contact.telephone}</td>		
			<td>${contact.customer.name}</td>
			<td>
				<c:if test="${contact.active}">
					Active
				</c:if>
				<c:if test="${!contact.active}">
					Not Active
				</c:if>
			</td>			
			<td>		
			<c:choose>  
			    <c:when test="${contact.type eq 'TECHNICAL'}">  
			      Technical  
			    </c:when>  
			    <c:when test="${contact.type eq 'BUSINESS'}">  
			        Business  
			    </c:when>  
			    <c:otherwise>  
			      Type is not defined  
			    </c:otherwise>  
			</c:choose>  
			</td>		
			<td>Groups</td>
			<td>
				<select name="Group">				
					 <c:forEach items="${contact.groups}" var="group">
	          			<option value="${group.id}">${group.name}</option>
	         		</c:forEach>
				</select>
			</td>			
		</tr>		
	 </c:forEach>
	
</table>

<h3>CRM JSTL DEMO LISTS</h3>

CheckBoxes: <br/>
<c:forEach items="${groups}" var="group">
	<input type="checkbox" name="groupSelected" value="${group}" /> ${group}<br/>	 
</c:forEach>	

Radio Options: <br/>
<c:forEach items="${groups}" var="group">
	<input type="radio" name="groupSelected" value="${group}" />${group} <br/> 
</c:forEach>


<br/>
<br/>
<a href="${pageContext.request.contextPath}/main/index"> Back To Index</a><br/>

</body>
</html>