<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
<c:set var = "contactsController" value = "${pageContext.request.contextPath}/contacts"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="${contactsController}/load?cid=1"> Demo Single Contact</a> <br/>
<a href="${contactsController}/list"> Demo List and Table</a><br/>
<a href="${contactsController}/newContactPage"> Demo Form</a><br/>

</body>
</html>