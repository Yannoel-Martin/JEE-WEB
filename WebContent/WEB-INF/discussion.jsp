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
			<div class="card-header d-flex justify-content-between">
				<p>Statut de la discussion :<c:choose>
					<c:when test="${discussion.status.id == 1}"> Ouvert</c:when>
					<c:when test="${discussion.status.id == 2}"> Fermé</c:when>
					<c:otherwise> En attente de validation</c:otherwise>
				</c:choose></p>
				<p><c:if test="${discussion.status.id == 1 && user.role.id == 1}">
					<a class="btn btn-danger" href="close">Fermer le topic</a>
				</c:if></p>
			</div>
			<div class="card-body">
				<c:forEach items="${messages}" var="message">
					<div class="message d-flex">
						<div class="right text-white">
							<p><c:out value="${message.owner.name}" /></p>
							<p><fmt:formatDate type = "both" dateStyle = "short" timeStyle = "short" value = "${message.sendDate}"/></p>
						</div>
						<div class="body">
							<br><c:out value="${message.body}" /><br>
						</div>
					</div>
					<br>
				</c:forEach>
			</div>
		</div>
		<style>
			.message { border: 1px solid black; }
			.message .right { border-right: 1px solid black; background-color: blue; padding: 8px; }
			.message .body { padding-left: 8px; }
		</style>
		<br>
		<c:if test="${discussion.status.id == 1}">
			<div class="card">
				<div class="card-header">
					<p>Message</p>	
				</div>
				<div class="card-body">
					<form method="POST" action="${requestScope['javax.servlet.forward.query_string']}">
						<div class="form-group">
							<textarea class="form-control" name="messageBody" rpws="5">Votre message (requis)</textarea>
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-primary">Répondre</button>
						</div>
					</form>
				</div>
			</div>
			<br>
		</c:if>
	</div>
	
	<%@include file="ressource/footer.html" %>
	
	<!-- import du script -->
	<%@include file="ressource/source-bootstrap.html" %>
		
</body>
</html>