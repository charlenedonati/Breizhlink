<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Soumission d'un lien � raccourcir</title>
		<link rel="stylesheet" type="text/css" href="style.css">
	</head>
	
	<body>
		<jsp:include page="header.jsp"/>

		<form action="Controleur" method="post">
		  	<p>Saisir l'URL Compl�te que vous souhaitez r�duire, ci dessous : </p> <input name="URL" type="text"> <button>Raccourcir</button>
		</form>
	</body>
	
	<jsp:include page="footer.jsp"/>
	
</html>