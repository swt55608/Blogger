<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="BIG5"%>
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


<%-- 	<h1>${sessionScope.username} Personal Page</h1> --%>
<!-- 	<a href="create_article.jsp">Create Article</a> -->
<%-- 	<c:forEach items="${sessionScope.authorArticles}" var="article"> --%>
<!-- 		<div style="border: 2px solid gray;"> -->
<%-- 			<h2>${article.title}</h2> --%>
<%-- 			<p>${article.content}</p> --%>
<%-- 			<h5>owned by ${article.authorName}</h5> --%>
<%-- 			<a href="edit_article.jsp?articleTitle=${article.title}">Edit</a>| --%>
<%-- 			<a href="DeleteArticleServlet?articleTitle=${article.title}">Delete</a> --%>
<!-- 		</div> -->
<!-- 		<br> -->
<%-- 	</c:forEach> --%>
	${requestScope.errorMessage}
	
	
	
	
	
	
	
	<!-- w3-content defines a container for fixed size centered content, 
	and is wrapped around the whole page content, except for the footer in this example -->
	<div class="w3-content" style="max-width:1400px">
	
		<!-- Header -->
		<header class="w3-container w3-center w3-padding-32"> 
		  <h1><b>MY BLOG</b></h1>
		  <p>Welcome to the blog of <span class="w3-tag">${sessionScope.username}</span></p>
		  <a href="create_article.jsp">Create an Article</a>
		</header>
		
		<!-- Grid -->
		<div class="w3-row">
		
			<!-- Blog entries -->
			<div class="w3-col l12 s12">
				<c:forEach items="${sessionScope.authorArticles}" var="article">
					<!-- Blog entry -->
					<div class="w3-card-4 w3-margin w3-white">
					  <div class="w3-container">
					    <h3><b>${article.title}</b></h3>
					    <h5><span class="w3-opacity">owned by ${article.authorName}</span></h5>
					  </div>
					
					  <div class="w3-container">
					     <p>${article.content}</p>
						 <div class="w3-row">
							 <div class="w3-col m8 s12">
							   <p><a class="w3-button w3-hover-blue w3-padding-large w3-white w3-border" href="edit_article.jsp?articleTitle=${article.title}"><b>Edit</b></a></p>
							 </div>
							 <div class="w3-col m4 s12 w3-right-align">
							   <p><a class="w3-button w3-hover-red w3-padding-large w3-black w3-border" href="DeleteArticleServlet?articleTitle=${article.title}"><b>Delete</b></a></p>
							</div>
					  	</div>
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