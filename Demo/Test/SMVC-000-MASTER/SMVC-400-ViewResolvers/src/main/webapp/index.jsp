<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<hr/>
<h3>View Resolvers demo:</h3>

<hr/>
<h3>JSP Demo:</h3>
<a href="${pageContext.request.contextPath}/views/demo/hello/jsp?page=page1">View Jsp Page1</a><br/>
<a href="${pageContext.request.contextPath}/views/demo/hello/jsp?page=page2">View Jsp Page2</a><br/>
<a href="${pageContext.request.contextPath}/views/demo/hello/jsp?page=page3">View Jsp Page3</a><br/>
<hr/>
<br/>
<br/>

<h3>Xml Demo:</h3>
<hr/>
<a href="${pageContext.request.contextPath}/views/demo/hello/xml?page=page1">View Xml Page1 </a><br/>
<a href="${pageContext.request.contextPath}/views/demo/hello/xml?page=page2">View Xml Page2 </a><br/>
<a href="${pageContext.request.contextPath}/views/demo/hello/xml?page=page3">View Xml Page3 </a><br/>
<hr/>
<br/>
<br/>

<h3>Props Demo:</h3>
<hr/>
<a href="${pageContext.request.contextPath}/views/demo/hello/prop?page=page1">View Xml Page1 </a><br/>
<a href="${pageContext.request.contextPath}/views/demo/hello/prop?page=page2">View Xml Page2 </a><br/>
<a href="${pageContext.request.contextPath}/views/demo/hello/prop?page=page3">View Xml Page3 </a><br/>
<hr/>
<br/>
<br/>

<h3>Custom View Demo:</h3>
<hr/>
<a href="${pageContext.request.contextPath}/views/demo/hello/view">Custom View</a><br/>
<hr/>
<br/>
<br/>

</body>
</html>