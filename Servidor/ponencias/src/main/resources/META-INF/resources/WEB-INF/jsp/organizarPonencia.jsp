<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Organizar ponencias</title>
</head>
<body>
	<h1>Organizando ponencia con aforo</h1>
<h2> ${mapa[organizarPonencia]} asistentes</h2>
	<form method="post" action="/aniadeAsistentes">
	<label>AÑADIR</label>
	<input type="hidden" name="tituloPonencia" value="${organizarPonencia.titulo}"/>
	<input type="number" name="asistentes" /> asistentes  
	<input type="submit" name="aniadeAsistentes" value="AÑADIR" />
	
</form>
	${errorAforo}
</body>
</html>