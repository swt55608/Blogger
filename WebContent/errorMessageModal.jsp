<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
	<div id="errorMessageModal" class="w3-modal">
	  <div class="w3-modal-content">
	    <header class="w3-container w3-red"> 
	      <span onclick="document.getElementById('errorMessageModal').style.display='none'" 
	      class="w3-button w3-display-topright">&times;</span>
	      <h2>Error Message</h2>
	    </header>
	    <div class="w3-container">
	      <p>${requestScope.errorMessage}</p>
	    </div>
	  </div>
	</div>

	<script>
	// Get the modal
	var modal = document.getElementById('errorMessageModal');
	
	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
	  if (event.target == modal) {
	    modal.style.display = "none";
	  }
	}
	</script>
</body>
</html>