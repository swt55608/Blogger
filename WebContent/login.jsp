<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
	<form action="LoginServlet" method="post">
		Username: <input type="text" name="username"> <br>
		Password: <input type="password" name="password"> <br>
		<input type="submit">
	</form>
	
	${sessionScope.username} <br>
	${requestScope.errorMessage}
</body>
</html>