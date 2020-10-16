<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
	<h1>Create an Article</h1>
	<form action="CreateArticleServlet" method="get">
		Title: <input type="text" name="articleTitle"> <br>
		Content: <input type="text" name="articleContent"> <br>
		<input type="submit">
	</form>
	${requestScope.errorMessage}
</body>
</html>