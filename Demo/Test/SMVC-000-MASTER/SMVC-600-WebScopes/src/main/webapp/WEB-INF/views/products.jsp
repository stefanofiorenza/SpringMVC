<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <form action="${pageContext.request.contextPath}/cart/add" method="post">
    <table>
      <tr>
        <td>Choose Product</td>
        <td>        
        <select name="pid">
        	<option value="1">Morellino Scansano</option>
        	<option value="2">Montepulciano</option>
        	<option value="3">Barbera</option>
        	<option value="4">Rosso Montalcino</option>
        	<option value="5">Negroamaro</option>
        	<option value="6">Amarone Valpolicella</option>
        </select>
        </td>
      </tr>
      <tr>
        <td><input type="reset" value="Cancel" /></td>
        <td><input type="submit" value="Add" /></td>
      </tr>
      <tr>
        <td></td>
      </tr>
    </table>
  </form>


<a href="${pageContext.request.contextPath}/cart/list">View Cart</a><br/>

</body>
</html>