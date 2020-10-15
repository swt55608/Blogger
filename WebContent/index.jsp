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
			Welcome! ${sessionScope.username} |
			<a href="LogoutServlet">Logout</a>
		</div>
	</c:if>
	
	
</body>
</html>