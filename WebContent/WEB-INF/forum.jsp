<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<!-- import des link -->
	<%@include file="ressource/header_link-bootstrap.html" %>
	<meta charset="ISO-8859-1">
	<title>JEE-WEB Forum</title>
</head>
<body>
	<div class="d-flex justify-content-between navigation">
		<a href="forum.jsp"><h1 class="h3">JEE-WEB Forum</h1></a>
		<a onclick="deconnexion();"><img src="ressource/logout.png"></a>
	</div>
	<script>
		function deconnexion() {
			//log out
		}
	</script>
	
	<div class="container">
	</div>
	<!-- import du script -->
	<%@include file="ressource/source-bootstrap.html" %>
</body>
</html>