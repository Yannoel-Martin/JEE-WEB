<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<!-- import du link -->
	<%@include file="ressource/header_link-bootstrap.html" %>
	<meta charset="ISO-8859-1">
	<title>Validation des sujets</title>
</head>
<body>

	<div class="d-flex justify-content-between navigation">
		<h1 class="h3 mb-0"><a href="/JEE-WEB/connexion-forum">JEE-WEB Forum</a></h1>
		<a href="/JEE-WEB/identification">
			<c:choose>
				<c:when test="${token != ''}">
					<span>${user.name}<i class="fa fa-power-off"></i></span>
				</c:when>
				<c:otherwise>
					<span>Connexion / Inscription</span>
				</c:otherwise>
			</c:choose>
		</a>
	</div>
	
	<style>
		.navigation { width: 100%; border-bottom: 1px solid black; }
		.navigation h1 { padding: 2px 0px 0px 8px; }
		.navigation a { color: black; }
		.navigation a:hover { text-decoration: none; }
		.navigation a i { font-size:25px; color:red; margin: 8px; }
	</style>

	<br>
	<div class="container">
		<div class="card">
			<div class="card-body">
				<c:forEach items="${discussions}" var="discussion">
					<div class="discussion">
						<div class="title">
							<a href="../discussion/${discussion.id}"><c:out value="${discussion.name}"/></a>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<br>
	</div>
	
	<%@include file="ressource/footer.html" %>
	
	<!-- import du script -->
	<%@include file="ressource/source-bootstrap.html" %>
		
</body>
</html>