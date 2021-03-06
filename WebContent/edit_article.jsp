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
	
	<%@ include file="errorMessageModal.jsp" %>
	<c:if test="${!empty requestScope.errorMessage}">
		<script>
		document.getElementById('errorMessageModal').style.display='block';
		</script>
	</c:if>

	<div class="w3-content" style="max-width:1400px">
	
		<!-- Header -->
		<header class="w3-container w3-center w3-padding-32"> 
		  <h1><b>MY BLOG</b></h1>
		  <p>Welcome to the blog of <span class="w3-tag">${sessionScope.username}</span></p>
		  <a href="index.jsp">Back to Index</a>
		</header>
		
		<!-- Grid -->
		<div class="w3-row">
		
			<!-- Blog entries -->
			<div class="w3-col l12 s12">
				<form action="EditArticleServlet" method="get"> 
					<!-- Blog entry -->
					<div class="w3-card-4 w3-margin w3-white">
					  <div class="w3-container">
					  	<input type="hidden" name="articleTitle" value="${param.articleTitle}">
					    <h3><b><input type="text" name="newArticleTitle" value="${param.articleTitle}" placeholder="Enter Title" style="background-color: white; border: 1px solid gray"></b></h3>
					  </div>
					
					  <div class="w3-container">
					     <p><textarea type="text" name="newArticleContent" placeholder="Enter Contents" rows="6" cols="100%" style="background-color: white; border: 1px solid gray">${param.articleContent}</textarea></p>
						 <div class="w3-row">
							<div class="w3-col m12 s12 w3-right-align">
								<p>
									<a href="author_personal_page.jsp" class="w3-button w3-hover-gray w3-padding-large w3-white w3-border"><b>Cancel</b></a>
									<button type="submit" class="w3-button w3-hover-blue w3-padding-large w3-black w3-border"><b>Edit</b></button>
								</p>
							</div>
					  	 </div>
					  </div>
					</div>
				<!-- END BLOG ENTRIES -->
				</form>
			</div>
		<!-- END GRID -->
		</div><br>
	
	<!-- END w3-content -->
	</div>
</body>
</html>