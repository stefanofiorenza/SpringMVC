<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DEMO Session Scopes</title>
</head>
<body>
  <h1>Login Success Page</h1>
  <p>You are logged in with email ${user.email}.</p>
 
  <!-- Click here to view the session attributes -->
  <hr/>User ADMIN
  <a href="${pageContext.request.contextPath}/user/info">View profile</a><br/>
  
   <hr/>EShop
  <a href="${pageContext.request.contextPath}/cart/">Products</a><br/>
</body>
</html>