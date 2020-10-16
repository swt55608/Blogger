<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="BIG5">
	<title>Insert title here</title>
</head>
<body>
	<c:if test="${empty sessionScope.username}">
		<div>
			<a href="register.jsp">Register</a> |
			<a href="login.jsp">Login</a>
		</div>
	</c:if>
	
	<c:if test="${!empty sessionScope.username}">
		<div>
			Welcome! <a href="author_personal_page.jsp">${sessionScope.username}</a> |
			<a href="LogoutServlet">Logout</a>
		</div>
	</c:if>
	
	<c:forEach items="${sessionScope.allArticles}" var="article">
		<div style="border: 2px solid gray;">
			<h2>${article.title}</h2>
			<p>${article.content}</p>
			<h5>owned by ${article.authorName}</h5>
		</div>
		<br>
	</c:forEach>
</body>
</html>