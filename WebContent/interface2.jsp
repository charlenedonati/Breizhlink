<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Url</title>
		<link rel="stylesheet" type="text/css" href="style.css">
	</head>
	
	<body>
		<jsp:include page="header.jsp"/>
		
		<h1>Votre r�duction d'adresse � fonctionner</h1>
		
		<p>
			Voici l'url que vous avez taper : <%= request.getAttribute("url") %> 
			<br>
			<br>
		    Ici vous avez l'url raccourci : <%= request.getAttribute("urlRacc") %> 
		</p>
	</body>
	
	<jsp:include page="footer.jsp"/>
</html>