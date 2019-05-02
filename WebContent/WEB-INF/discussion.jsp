<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Discussion - [Nom de la Discussion]</title>
</head>
<body>
	<div class="container">
		<span>
		----------Liste des messages----------<br>
			<c:forEach items="${messages}" var="message">
				<div class="message">
					<div class="title">
						<c:out value="${message.utilisateur.name}" />
					</div>
					<div class="body">
						<c:out value="${message.content}" />
					</div>
					<div class="date">
						<c:out value="${message.date}" />
					</div>
				</div>
			</c:forEach>
		</span>
		<form method="get" action="newMessage">
		    <fieldset>
		        <legend>Message</legend>
		
		        <label for="messageBody"><span class="requis">*</span></label>
		        <input type="text" name="messageBody" value="" size="80" maxlength="20"/>
		        <br/>
		        
		    </fieldset>
		    <input type="submit" value="R�pondre"/>
		</form>
	</div>
</body>
</html>