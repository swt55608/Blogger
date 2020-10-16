<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
</head>
<body class="w3-light-grey">
	

<%-- 	<c:if test="${empty sessionScope.username}"> --%>
<!-- 		<div> -->
<!-- 			<a href="register.jsp">Register</a> | -->
<!-- 			<a href="login.jsp">Login</a> -->
<!-- 		</div> -->
<%-- 	</c:if> --%>
	
<%-- 	<c:if test="${!empty sessionScope.username}"> --%>
<!-- 		<div> -->
<%-- 			Welcome! <a href="author_personal_page.jsp">${sessionScope.username}</a> | --%>
<!-- 			<a href="LogoutServlet">Logout</a> -->
<!-- 		</div> -->
<%-- 	</c:if> --%>
	
<%-- 	<c:forEach items="${sessionScope.allArticles}" var="article"> --%>
<!-- 		<div style="border: 2px solid gray;"> -->
<%-- 			<h2>${article.title}</h2> --%>
<%-- 			<p>${article.content}</p> --%>
<%-- 			<h5>owned by ${article.authorName}</h5> --%>
<!-- 		</div> -->
<!-- 		<br> -->
<%-- 	</c:forEach> --%>
	
	
	
	
	
	
	<%@ include file="register.jsp" %>
	<%@ include file="login.jsp" %>
	
	<!-- w3-content defines a container for fixed size centered content, 
	and is wrapped around the whole page content, except for the footer in this example -->
	<div class="w3-content" style="max-width:1400px">
	
		<!-- Header -->
		<header class="w3-container w3-center w3-padding-32"> 
		  <h1><b>BLOGGER</b></h1>
		  <c:if test="${empty sessionScope.username}">
				<div>
					<button onclick="document.getElementById('registerModal').style.display='block'" style="width:auto; background-color: #ff6666">Register</button>
					<button onclick="document.getElementById('loginModal').style.display='block'" style="width:auto;">Login</button>
				</div>
			</c:if>
			
			<c:if test="${!empty sessionScope.username}">
				<div>
					Welcome! <a href="author_personal_page.jsp">${sessionScope.username}</a> |
					<a href="LogoutServlet">Logout</a>
				</div>
			</c:if>
		</header>
		
		<!-- Grid -->
		<div class="w3-row">
		
			<!-- Blog entries -->
			<div class="w3-col l12 s12">
				<c:forEach items="${sessionScope.allArticles}" var="article">
					<!-- Blog entry -->
					<div class="w3-card-4 w3-margin w3-white">
					  <div class="w3-container">
					    <h3><b>${article.title}</b></h3>
					    <h5><span class="w3-opacity">owned by ${article.authorName}</span></h5>
					  </div>
					  
					  <div class="w3-container">
					     <p>${article.content}</p>
					  </div>
					</div>
					<hr>
				</c:forEach>
			<!-- END BLOG ENTRIES -->
			</div>
		
		<!-- END GRID -->
		</div><br>
	
	<!-- END w3-content -->
	</div>
	
</body>
</html>