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
	<h1>${sessionScope.username} Personal Page</h1>
	<a href="create_article.jsp">Create Article</a>
	<c:forEach items="${sessionScope.authorArticles}" var="article">
		<div style="border: 2px solid gray;">
			<h2>${article.title}</h2>
			<p>${article.content}</p>
			<h5>owned by ${article.authorName}</h5>
			<a href="edit_article.jsp?articleTitle=${article.title}">Edit</a>|
			<a href="DeleteArticleServlet?articleTitle=${article.title}">Delete</a>
		</div>
		<br>
	</c:forEach>
	${requestScope.errorMessage}
</body>
</html>