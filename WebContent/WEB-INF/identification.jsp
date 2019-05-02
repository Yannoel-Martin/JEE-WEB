<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<!-- import du link -->
	<%@include file="ressource/header_link-bootstrap.html" %>
	<meta charset="ISO-8859-1">
	<title>Connexion/Inscription</title>
</head>
<body>
<div class="navigation">
	<h1 class="h3 mb-0"><a href="/JEE-WEB/connexion-forum">JEE-WEB Forum</a></h1>
</div>

<style>
	.navigation { width: 100%; border-bottom: 1px solid black; }
	.navigation h1 { padding: 2px 0px 0px 8px; }
	.navigation a { color: black; }
	.navigation a:hover { text-decoration: none; }
</style>
<br>
	<div class="container">
		<div class="row">
			<div class="col-sm-6">
				<div class="card" id="inscription">
					<div class="card-header text-center text-white">
						<h2>Inscription <i class="fa fa-pencil"></i></h2>
					</div>
					<div class="card-body">
						<form method="post" action="subscribe">
						  <div class="form-group">
						    <input type="text" class="form-control" id="login_ins" placeholder="Login (requis)">
						  </div>
						  <div class="form-group">
						    <input type="password" class="form-control" id="password_ins" placeholder="Password (requis)">
						  </div>
						  <div class="form-group">
						    <div class="form-check">
							  <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios1" value="1" checked>
							  <label class="form-check-label" for="exampleRadios1">
							    Utilisateur
							  </label>
							</div>
							<div class="form-check">
							  <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios2" value="2">
							  <label class="form-check-label" for="exampleRadios2">
							    Administrateur
							  </label>
							</div>
						  </div>
						  <div class="form-group">
							  <button type="submit" class="btn btn-primary">Envoyer <i class="fa fa-location-arrow"></i></button>
						  </div>
						</form>
					</div>
				</div>
				<br>
			</div>
			<div class="col-sm-6">
				<div class="card" id="connexion">
					<div class="card-header text-center text-white">
						<h2>Connexion <i class="fa fa-lock"></i></h2>
					</div>
					<div class="card-body">
						<form method="post" action="connexion">
							<div class="form-group">
								<input type="text" class="form-control" id="login_con" placeholder="Login (requis)">
							</div>
							<div class="form-group">
								<input type="password" class="form-control" id="password_con" placeholder="Password (requis)">
							</div>
							<div class="form-group">
								<button type="submit" class="btn btn-primary">Envoyer <i class="fa fa-location-arrow"></i></button>
							</div>
						</form>
					</div>
				</div>
				<br>
			</div>
		</div>
	</div>
	<style>
		#inscription .card-header { background-color: #c10000; }
		#connexion .card-header { background-color: #006f00; }
	</style>
	
	<%@include file="ressource/footer.html" %>
	<!-- import du script -->
	<%@include file="ressource/source-bootstrap.html" %>
</body>
</html>