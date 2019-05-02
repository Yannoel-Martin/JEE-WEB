<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forum - [Nom du Forum]</title>
</head>
<body>
	<p>
	----------Liste des sujets----------<br>
		<c:forEach items="${sujets}" var=sujet>
			<div class="sujet">
				<div class="title">
					<c:out value="${sujet.nom}" />
				</div>
			</div>
		</c:forEach>
	</p>
</body>
</html>