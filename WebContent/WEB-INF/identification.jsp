<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<!-- import des link -->
	<%@include file="ressource/header_link-bootstrap.html" %>
	<meta charset="ISO-8859-1">
	<title>JEE-WEB Forum</title>
</head>
<body>
<br>
	<div class="container">
		<div class="row">
			<div class="col-sm-1"/>
			<div class="col-sm-5">
				<div class="card">
					<div class="card-header text-center">
						<h2>Inscription <i class="fa fa-pencil"></i></h2>
					</div>
					<div class="card-body">
						<form method="post" action="subscribe">
						  <div class="form-group">
						    <input type="text" class="form-control" id="exampleInputPassword1" placeholder="Login">
						  </div>
						  <div class="form-group">
						    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
						  </div>
						  <div class="form-group">
							  <button type="submit" class="btn btn-primary">Envoyer <i class="fa fa-location-arrow"></i></button>
						  </div>
						</form>
					</div>
				</div>
				<br>
			</div>
			<div class="col-sm-5">
				<div class="card">
					<div class="card-header text-center">
						<h2>Connexion <i class="fa fa-lock"></i></h2>
					</div>
					<div class="card-body">
						<form method="post" action="connexion">
							<div class="form-group">
								<input type="text" class="form-control" id="exampleInputPassword1" placeholder="Login">
							</div>
							<div class="form-group">
								<input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
							</div>
							<div class="form-group">
								<button type="submit" class="btn btn-primary">Envoyer <i class="fa fa-location-arrow"></i></button>
							</div>
						</form>
					</div>
				</div>
				<br>
			</div>
			<div class="col-sm-1"/>
		</div>
	</div>
	<!-- import du script -->
	<%@include file="ressource/source-bootstrap.html" %>
</body>
</html>