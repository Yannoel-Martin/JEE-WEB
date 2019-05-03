<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
						<c:out value="${message.owner.name}" />
					</div>
					<div class="body">
						<c:out value="${message.body}" />
					</div>
					<div class="date">
						<fmt:formatDate type = "both" dateStyle = "short" timeStyle = "short" value = "${message.sendDate}"/>
					</div>
				</div>
			</c:forEach>
		</span>
		<form method="POST" action="${requestScope['javax.servlet.forward.query_string']}">
		    <fieldset>
		        <legend>Message</legend>
		
		        <label for="messageBody"><span class="requis">*</span></label>
		        <input type="text" name="messageBody" value="" size="80" maxlength="20"/>
		        <br/>
		        
		    </fieldset>
		    <input type="submit" value="Répondre"/>
		</form>
	</div>
</body>
</html>