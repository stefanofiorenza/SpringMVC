<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DEMO Session Scopes</title>
</head>
<body>
  <h1>User profile Page</h1>
  <table>
    <tr>
      <td>First Name</td>
      <td>${userLogged.fname}</td>
    </tr>
    <tr>
      <td>Middle Name</td>
      <td>${userLogged.mname}</td>
    </tr>
    <tr>
      <td>Last Name</td>
      <td>${userLogged.lname}</td>
    </tr>
    <tr>
      <td>Age</td>
      <td>${userLogged.age}</td>
    </tr>
  </table>
  
 <a href="${pageContext.request.contextPath}/user/logout">Logout</a><br/>
 <a href="${pageContext.request.contextPath}/user/main">Back to Index Page</a><br/>
  
</body>
</html>