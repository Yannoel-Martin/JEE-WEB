<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<!-- import des link -->
	<%@include file="WEB-INF/ressource/header_link-bootstrap.html" %>
	<meta charset="ISO-8859-1">
	<title>JEE-WEB Forum</title>
</head>
<body>
<br>
	<c:choose>
		<c:when test="${ token != '' }">
			<div class="container">
				<div class="row">
					<div class="col-sm-1"/>
					<div class="col-sm-5">
						<div class="card">
							<div class="card-header text-center">
								<h2>Inscription <i class="fa fa-pencil"></i></h2>
							</div>
							<div class="card-body">
							</div>
						</div>
						<br>
					</div>
					<div class="col-sm-5">
						<div class="card">
							<div class="card-header text-center">
								<h2>Connexion <i class="fa fa-lock"></i></h2>
							</div>
							<div class="card-body">
							</div>
						</div>
						<br>
					</div>
					<div class="col-sm-1"/>
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<c:redirect><c:out value="/connexion-forum"/></c:redirect>
		</c:otherwise>
	</c:choose>
	<!-- import du script -->
	<%@include file="WEB-INF/ressource/source-bootstrap.html" %>
</body>
</html>