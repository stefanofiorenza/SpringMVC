<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DEMO Session Scopes</title>
</head>
<body>
  	<h1>Shopping Cart</h1>
  	Products In Cart:
	<ul>
	<c:forEach items="${productsInCart}" var="product">
	<li>
	${product}
	<li>
	</c:forEach>
	</ul>
	<br/>
	<br/>
	Remove element from cart:
	<form action="${pageContext.request.contextPath}/cart/remove" method="post">
    <table>
      <tr>
        <td>Choose Product</td>
        <td>        
        <select name="pid">
        	<c:forEach items="${productsInCart}" var="product">
        	<option value="${product.id}" />  ${product.name}</option>
        	</c:forEach>      	
        </select>
        </td>
      </tr> 
      <tr>
        <td><input type="reset" value="Cancel" /></td>
        <td><input type="submit" value="Remove" /></td>
      </tr>     
    </table>
  </form>
  
<a href="${pageContext.request.contextPath}/cart/">Back to Products profile</a><br/>
</body>
</html>