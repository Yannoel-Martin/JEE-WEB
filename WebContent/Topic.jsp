<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Topic - [Nom du Sujet]</title>
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
	<form method="get" action="newDiscussion">
	    <fieldset>
	        <legend>Topic</legend>
	
	        <label for="discussionName">Nom<span class="requis">*</span></label>
	        <input type="text" name="discussionName" value="" size="40" maxlength="20"/>
	        <br/>
	        
	    </fieldset>
	    <input type="submit" value="Ajouter"/>
	</form>
</body>
</html>