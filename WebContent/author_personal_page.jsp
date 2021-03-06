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
	<style>
	.w3-allerta {
	  font-family: "Allerta Stencil", Sans-serif;
	}
	</style>
</head>
<body class="w3-light-grey">
	
	<!-- w3-content defines a container for fixed size centered content, 
	and is wrapped around the whole page content, except for the footer in this example -->
	<div class="w3-content" style="max-width:1400px">
	
		<!-- Header -->
		<header class="w3-container w3-center w3-padding-32"> 
		  <h1><b>MY BLOG</b></h1>
		  <p>Welcome to the blog of <span class="w3-tag">${sessionScope.username}</span></p>
		  <a href="create_article.jsp">Create an Article</a> | 
		  <a href="index.jsp">Back to Index</a>
		</header>
		
		<!-- Grid -->
		<div class="w3-row">
		
			<c:if test="${empty sessionScope.authorArticles}">
				<a href="create_article.jsp">
					<div class="w3-container w3-gray w3-hover-green w3-center w3-allerta">
					  <p class="w3-xxlarge">No Article here...Create a new one</p>
					</div>
				</a>
			</c:if>
			
			<c:if test="${!empty sessionScope.authorArticles}">
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
								   <p><a class="w3-button w3-hover-blue w3-padding-large w3-white w3-border" href="edit_article.jsp?articleTitle=${article.title}&articleContent=${article.content}"><b>Edit</b></a></p>
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
			</c:if>
			
		
		<!-- END GRID -->
		</div><br>
	
	<!-- END w3-content -->
	</div>
</body>
</html>