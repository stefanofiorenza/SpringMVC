<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:set var = "formMainControllerPath" value = "${pageContext.request.contextPath}/forms/main"/>
<c:set var = "formUserControllerPath_V1" value = "${pageContext.request.contextPath}/forms/users/v1"/>
<c:set var = "formUserControllerPath_V2" value = "${pageContext.request.contextPath}/forms/users/v2"/>
<c:set var = "formUserControllerPath_V3" value = "${pageContext.request.contextPath}/forms/users/v3"/>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="${formUserControllerPath_V1}/load">Demo Controller As Data Display</a><br/>
<a href="${formUserControllerPath_V1}/save">Demo Controller As Form Processor</a><br/>
<a href="${formUserControllerPath_V2}/save">Demo Controller With Validators</a><br/>
<a href="${formUserControllerPath_V3}/step1">Demo Controller With Sessions</a><br/>
</body>
</html>