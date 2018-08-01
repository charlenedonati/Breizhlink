<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Creer votre compte</title>
		<link rel="stylesheet" type="text/css" href="style.css">
	</head>
	
	<body>
		<jsp:include page="header.jsp"/>
		<p> Vous pouvez créer votre compte</p>
		
		<form action="Crea_compte" method="post">
			<input type="text" name="Login" value="" placeholder="Login"/>
			<input type="text" name="Email" value="" placeholder="Email"/>
			<input type="text" name="Password" value="" placeholder="Password"/>
			<input type="submit" name="Enregistrer" value="Enregistrer" />
		</form>
		
	</body>
	
	<jsp:include page="footer.jsp"/>
</html>