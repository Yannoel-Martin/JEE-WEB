<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Discussion - [Nom de la Discussion]</title>
</head>
<body>
	<p>
	----------Liste des messages----------<br>
		<c:forEach items="${messages}" var=message>
			<div class="message">
				<div class="title">
					<c:out value="${message.utilisateur.nom}" />
				</div>
				<div class="body">
					<c:out value="${message.contenu}" />
				</div>
				<div class="date">
					<c:out value="${message.date}" />
				</div>
			</div>
		</c:forEach>
	</p>
</body>
</html>