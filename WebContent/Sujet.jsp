<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sujet - [Nom du Sujet]</title>
</head>
<body>
	<p>
	----------Liste des discussions----------<br>
		<c:forEach items="${discussions}" var=discussion>
			<div class="discussion">
				<div class="title">
					<c:out value="${discussion.nom}" />
				</div>
			</div>
		</c:forEach>
	</p>
</body>
</html>