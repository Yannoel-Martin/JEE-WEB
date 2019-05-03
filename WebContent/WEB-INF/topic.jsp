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
		<span>
		----------Liste des discussions----------<br>
			<c:forEach items="${discussions}" var="discussion">
				<div class="discussion">
					<div class="title">
						<c:out value="${discussion.name}" />
					</div>
				</div>
			</c:forEach>
		</span>
		<form method="POST" action="${requestScope['javax.servlet.forward.query_string']}">
		    <fieldset>
		        <legend>Topic</legend>
		
		        <label for="discussionName">Nom<span class="requis">*</span></label>
		        <input type="text" name="discussionName" value="" size="40" maxlength="20"/>
		        <br/>
		        
		    </fieldset>
		    <input type="submit" value="Ajouter"/>
		</form>
	
	<%@include file="ressource/footer.html" %>
	
	<!-- import du script -->
	<%@include file="ressource/source-bootstrap.html" %>
		
</body>
</html>