<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Connexion/Inscription</title>
</head>
<body>
	<form method="get" action="logIn">
	    <fieldset>
	        <legend>Connexion</legend>
	
	        <label for="userName"><span class="requis">Nom*</span></label>
	        <input type="text" name="userName" value="" size="40" maxlength="20"/>
	        <br/>
	        
	        <label for="userPassword"><span class="requis">Mot de passe*</span></label>
	        <input type="text" name="userPassword" value="" size="40" maxlength="20"/>
	        <br/>
	        
	    </fieldset>
	    <input type="submit" value="Se connecter"/>
	</form>
	
	<form method="get" action="Register">
	    <fieldset>
	        <legend>Inscription</legend>
	
	        <label for="userName"><span class="requis">Nom*</span></label>
	        <input type="text" name="userName" value="" size="40" maxlength="20"/>
	        <br/>
	        
	        <label for="userPassword"><span class="requis">Mot de passe*</span></label>
	        <input type="text" name="userPassword" value="" size="40" maxlength="20"/>
	        <br/>
	        
	        <label for="userRole"><span class="requis">Role*</span></label><br/>
	        <input type="radio" name="userRole" value="User">Utilisateur<br/>
	        <input type="radio" name="userRole" value="Admin">Administrateur<br/>
	        
	    </fieldset>
	    <input type="submit" value="S'inscrire"/>
	</form>
	
</body>
</html>