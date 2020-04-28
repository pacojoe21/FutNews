<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Search results</title>
</head>
<body>



<fieldset id="videos">
<legend>Google Books search for <c:out value="${param.searchQuery}"/></legend>
<c:forEach items="${requestScope.items}" var="book">
	<span>Book title: <c:out value="${YouTubeSearch.items}"/>
		
	</span><br/>
</c:forEach>
</fieldset>



</body>
</html>