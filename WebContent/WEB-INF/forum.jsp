<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>JEE-WEB Forum</title>
	<!-- import des link -->
	<%@include file="ressource/header_link-bootstrap.html" %>
	<meta charset="ISO-8859-1">
</head>
<body>
	<%@include file="ressource/navigation.html" %>
	<div class="container">
		<div id="topics">
			<c:forEach items="${topics}" var="topic">
				<div class="topic">
					<div class="title">
						<a href="../topic/${topic.id}"><c:out value="${topic.name}"/></a>
					</div>
				</div>
			</c:forEach>
		</div>
		<br>
		<div class="card">
			<div class="card-header">
				<p>Topic</p>	
			</div>
			<div class="card-body">
				<form method="POST" action="${requestScope['javax.servlet.forward.query_string']}">
					<div class="form-group">
				        <input type="text" class="form-control" name="topicName" value="" maxlength="255" placeholder="Nom du topic (requis)"/>
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