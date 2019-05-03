<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<!-- import du link -->
	<%@include file="ressource/header_link-bootstrap.html" %>
	<meta charset="ISO-8859-1">
	<title>Topic - [Nom du Sujet]</title>
</head>
<body>
	<%@include file="ressource/navigation.html" %>
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
		<div class="card">
			<div class="card-header">
				<p>Discussion</p>	
			</div>
			<div class="card-body">
				<form method="POST" action="${requestScope['javax.servlet.forward.query_string']}">
					<div class="form-group">
						<input type="text" name="discussionName" value="" size="40" maxlength="20" placeholder="Nom de la discussion (requis)"/>
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-primary">Ajouter</button>
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