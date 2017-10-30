<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title><tiles:insertAttribute name="title" /></title>
	<tiles:insertAttribute name="head-meta" />
	<tiles:insertAttribute name="head-css" />
</head>

<body>
<tiles:insertAttribute name="menu" />

<div id="logo">
	<h1><a href="#">Collaboration</a></h1>
	<h2>&nbsp;</h2>
</div>
<div id="splash">
	<img src="${pageContext.request.contextPath}/resources/images/img05.jpg" alt="" />
</div>
<hr />
<div id="page">
	<div id="content">
		<tiles:insertAttribute name="content" />
	</div>		
	<tiles:insertAttribute name="sidebar" />
</div>
<!-- end #page -->
<tiles:insertAttribute name="footer" />
</body>
</html>
