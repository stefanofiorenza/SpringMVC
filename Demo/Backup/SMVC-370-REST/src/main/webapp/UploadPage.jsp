<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="uploadSingle" value="${pageContext.request.contextPath}/rest/binaries/upload/single" />
<c:set var="uploadMultiple" value="${pageContext.request.contextPath}/rest/binaries/upload/multiple" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>    <html class="lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>    <html class="lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html> <!--<![endif]-->
<head>
<title>Spring Upload Example</title>
</head>
<body>
	
<form method="POST" action="${uploadSingle}" enctype="multipart/form-data">
		upload: <input type="file" name="uploadedFile">	
		<input type="submit" value="Upload"> Upload Single File
</form>	
	<br/>
	<br/>
<form method="POST" action="${uploadMultiple}" enctype="multipart/form-data">
		File1 to upload: <input type="file" name="file"><br/>		 
		File2 to upload: <input type="file" name="file"><br/>
		<input type="submit" value="Upload"> Upload Files
</form>



</body>
</html>