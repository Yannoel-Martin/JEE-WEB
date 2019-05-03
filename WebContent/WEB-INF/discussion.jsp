<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
	<!-- import du link -->
	<%@include file="ressource/header_link-bootstrap.html" %>
	<meta charset="ISO-8859-1">
	<title>Discussion - [Nom de la Discussion]</title>
</head>
<body>
	<%@include file="ressource/navigation.html" %>
	<div class="container">
		<div class="card">
			<div class="card-body">
				<c:forEach items="${messages}" var="message">
					<div class="message">
						<div class="title">
							<c:out value="${message.owner.name}" />
						</div>
						<div class="body">
							<c:out value="${message.body}" />
						</div>
						<div class="date">
							<fmt:formatDate type = "both" dateStyle = "short" timeStyle = "short" value = "${message.sendDate}"/>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<br>
		<div class="card">
			<div class="card-header">
				<p>Message</p>	
			</div>
			<div class="card-body">
				<form method="POST" action="${requestScope['javax.servlet.forward.query_string']}">
					<div class="form-group">
						<input type="text" name="messageBody" value="" size="80" maxlength="20" placeholder="Votre message (requis)"/>
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-primary">Répondre</button>
					</div>
				</form>
			</div>
		</div>
		<br>
	</div>
	
	<%@include file="ressource/footer.html" %>
	
	<!-- import du script -->
	<%@include file="ressource/source-bootstrap.html" %>
		
</body>
</html>