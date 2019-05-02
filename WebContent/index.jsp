<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<!-- import des link -->
	<%@include file="WEB-INF/ressource/header_link-bootstrap.html" %>
	<meta charset="ISO-8859-1">
	<title>JEE-WEB Forum</title>
</head>
<body>
	<jsp:forward page="/connexion-forum" />
	<!-- import du script -->
	<%@include file="WEB-INF/ressource/source-bootstrap.html" %>
</body>
</html>