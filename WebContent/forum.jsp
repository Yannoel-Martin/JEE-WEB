<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forum - [Nom du Forum]</title>
</head>
<body>
	<div class="container">
		<span>
		----------Liste des topics----------<br>
			<c:forEach items="${topics}" var="topic">
				<div class="topic">
					<div class="title">
						<c:out value="${topic.name}"/>
					</div>
					<div class="length">
						<c:out value="${topic.length}"/>
					</div>
				</div>
			</c:forEach>
		</span>
		<form method="get" action="newTopic">
		    <fieldset>
		        <legend>Topic</legend>
		
		        <label for="topicName">Nom<span class="requis">*</span></label>
		        <input type="text" name="topicName" value="" size="20" maxlength="20"/>
		        <br/>
		        
		    </fieldset>
		    <input type="submit" value="Ajouter"/>
		</form>
	</div>
</body>
</html>