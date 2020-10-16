<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
	<h1>Edit an Article: ${param.articleTitle}</h1>
	<form action="EditArticleServlet" method="get">
		<input type="hidden" name="articleTitle" value="${param.articleTitle}">
		Title: <input type="text" name="newArticleTitle"> <br>
		Content: <input type="text" name="newArticleContent"> <br>
		<input type="submit">
	</form>
	${requestScope.errorMessage}
</body>
</html>